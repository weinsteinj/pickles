<template>
  <div class="main-container">
    <div class="left-panel">
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Nulla tempora
      repudiandae necessitatibus architecto. Reiciendis adipisci at fuga aut
      ratione! Obcaecati deleniti architecto aliquam repellendus optio ea,
      dolorem voluptatum nulla fuga.
      <h2>Pickles</h2>
      <p></p>

      <img
        src="../assets/images/woman-withdog.svg"
        alt="woman with dog"
        class="woman-with-dog"
      />
    </div>

    <div class="info-container">
      <h1 id="usernameDetails" class="play-details">
        {{ activePlaydate.hostUsername }}'s Playdate
      </h1>
      <div id="playDetails" class="play-details">
        <h2>Details:</h2>
        <p>{{ activePlaydate.details }}</p>
      </div>
      <div id="timeDetails" class="play-details">
        <h2>Time:</h2>
        <p>{{ changeDateTime(activePlaydate.dateTime) }}</p>
      </div>
      <div id="hostDetails" class="play-details">
        <h2>Host:</h2>
        <p>{{ activePlaydate.hostUsername }}</p>
      </div>
      <div id="petDetails" class="play-details">
        <h2>Pets:</h2>
        <p v-for="pet in pets" v-bind:key="pet.id">
         <router-link class="router-link" :to="{name: 'pet-info', params: {petId: pet.petId}}"> {{ pet.name }}</router-link>
          </p>
      </div>

      <div id="locDetails" class="location-details">
        <h2>Location:</h2>
        <div class="map-panel">
          <playdate-details-map></playdate-details-map>
        </div>
      </div>
      <div id="imgDetails" class="img-panel">
        <h2>Photo:</h2>
        <img
          v-if="activePlaydate.playdatePhoto !== ''"
          :src="activePlaydate.playdatePhoto"
        />
      </div>
      <div id="invite" v-cloakv-if="activePlaydate.hostUserId !== $store.state.user.id">
       <div
        class="play-details"
        v-if="activePlaydate.status == 'Posted'"
      >

        <h2 class="h2-last">Want to come to this playdate? Request an invitation!</h2>
        <button class="btn" @click="requestInvite">Request an Invite</button>
       </div>
      </div> 
      <div class="h2-last" id="invSent" v-if="activePlaydate.status == 'Pending'">
        <h2>An invite has been requested, check back soon!</h2>
      </div>
    </div>

    <div class="right-panel"></div>
  </div>
</template>

<script>
import playdateService from "@/services/playdateService.js";
import PlaydateDetailsMap from "@/components/PlaydateDetailsMap.vue";
import moment from "moment";

export default {
  name: "playdate-details",
  components: {
    PlaydateDetailsMap,
  },
  data() {
    return {
      pets: [{}],
      activePlaydate: {},
    };
  },
  // created() {

  //   },
  created() {
    playdateService.getById(this.$route.params.playdateId).then((response) => {
      this.activePlaydate = response.data;
      console.log(this.activePlaydate.status);
      this.$store.commit("SET_ACTIVE_PLAYDATE", this.activePlaydate);

      const unique = (value, index, self) => {
        return self.indexOf(value) === index;
      };

      let allPetsArray = this.$store.state.petArray;
      let playdatePets = this.activePlaydate.petId;

      for (let i = 0; i < allPetsArray.length; i++) {
        playdatePets.forEach((element) => {
          allPetsArray.forEach((pet) => {
            let petIdHere = pet.petId;

            if (element == petIdHere) this.pets.push(pet);
          });
        });
        this.pets(unique); //what is this doing? - it keeps giving me errors
      }
    });
  },
  methods: {
    requestInvite() {
      this.activePlaydate.visitingUserId = this.$store.state.user.id;
      this.activePlaydate.status = "Pending";
      playdateService
        .updatePlaydate(this.activePlaydate.playdateId, this.activePlaydate)
        .then((response) => {
          console.log(response.data);
        })
        //commit this to the store?
        .catch((err) => console.error(err));
    },
    changeDateTime(dateTime) {
      let dateTimeFormat = moment(dateTime).format("MMMM Do YYYY, h:mm a");
      return dateTimeFormat;
    },
  },
  // computed: {
  //     getPetsForPlaydateDetails() {
  //       console.log(this.playdate);
  //       for (var petid of this.playdate.petId) {
  //           for (var pet of this.$store.state.petArray) {
  //               if (pet.petId===petid) {
  //                 //  this.pet.push(pet); //this is what is not working!
  //               }
  //           }
  //       }
  //       return this.pets; //next try to move this back to created
  //     }

  // }
};
</script>

<style scoped>
#usernameDetails {
  grid-area: username;
}

#playDetails {
  grid-area: play;
}
#timeDetails {
  grid-area: time;
}
#hostDetails {
  grid-area: host;
}
#petDetails {
  grid-area: pets;
}
#locDetails {
  grid-area: map;
}
#imgDetails {
  grid-area: image;
}
#invite {
  grid-area: invite;
}
#invSent{
  grid-area: invite;
}

.play-details {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.main-container {
  display: flex;
  justify-content: space-between;
}
.info-container {
  display: grid;
  grid-template-columns: 1fr 0.75fr 1fr;
  grid-template-rows: 80px 150px 350px 80px;
  grid-template-areas:
    " username username username "
    "time host play"
    "map pets image"
    ". invite .";
}

.map-panel {
  overflow: hidden;
  width: 50%;
  flex-grow: 1;
}
.map-panel[data-v-fae5bece] {
  width: 100%;
  display: flex;
  /* flex-shrink: 5; */
  flex-direction: column;
  flex-wrap: wrap;
  /* align-content: stretch; */
  /* justify-content: flex-end; */
  /* align-items: stretch; */
}
.map-panel[data-v-7acf9e00] {
  width: 100%;
  height: 600%;
}

div > p {
  font-size: 20px;
}
.img-panel {
  display: flex;
  flex-direction: column;
  justify-content: center;
  justify-content: flex-start;
  align-items: center;
}

#imgDetails > img {
  object-fit: cover;
  height: 100%;
  max-width: 100%;
}
.left-panel {
  width: 20rem;
  margin-right: 50px;
}
.right-panel {
  width: 20rem;
  margin-left: 50px;
}

.vue-map {
  overflow: initial;
}

.location-details {
  display: flex;
  flex-direction: column;
  height: 400px;
  justify-content: flex-end;
  align-items: center;
}
div.vue-map {
  opacity: 10%;
}

h1 {
  margin-top: 0;
}

.router-link {
    text-decoration: none;
    color: var(--primary-green);
}

.h2-last {
  margin-top: 4rem;
}
</style>