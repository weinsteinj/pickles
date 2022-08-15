<template>
  <div>
      <div id = "app">
        <div class ="scroll">
          <div></div>
        <playdate-card v-for="playdate in $store.state.playdateArray" v-bind:key="playdate.id" 
        v-bind:playdate="playdate" ></playdate-card>
        </div>
      </div>
  </div>
</template>


<script src="https://unpkg.com/vue"></script>
<script>

// import playdateService from '@/services/playdateService.js'
import PlaydateCard from '@/components/PlaydateCard.vue'

export default {
  name: "play",
  components: {
    PlaydateCard,
  },
  
  created () {
    this.savePlaydatesToStore;
  },
  data () {
    return {
    
    }
  },
  methods: {
    scrollToEnd() {
				var container = document.querySelector(".scroll");
				var scrollHeight = container.scrollHeight;
				container.scrollTop = scrollHeight;
			},
    //  scrollToElement() {
    //   const [el] = this.$refs.last;
    //   if (el) {
    //     el.scrollIntoView({ behavior: "smooth" });
    //   }
    // },
    // savePlaydatesToStore() {
    //   playdateService.getAllPlaydates()
    //    .then(response => {
    //      if(response.status === 200) {
    //        let playdateArray = response.data;
    //        this.$store.commit('ADD_ALL_PLAYDATE', playdateArray);
    //      }
    //    })
    //    .catch(() => {
    //        alert("Sorry. An error occurred.")
    //      })
    // },
  },
  mounted() {
			this.scrollToEnd();
		},
		updated() {
			this.scrollToEnd();
    }
}
</script>

<style>
.scroll{
  overflow-x: hidden;
	max-height: 485px;
	overflow-y: scroll;
	
	margin-bottom: 20px;
  border-radius: 10px;
}

body {
  padding-top: 1rem;
  padding-bottom: 5px;
}

 .home {
  padding-top: 100px;
}
</style>