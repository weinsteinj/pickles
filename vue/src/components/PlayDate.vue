<template>
  <div>
      <div id = "app">
         <h1>Check out our current Playdates</h1>
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
body {
    overflow-x: hidden;
  
}
h1 {
  padding: 0px;
  margin: 0px;
  text-align: center;
}
.scroll{
  overflow-x: hidden;
	max-height: 435px;
	overflow-y: scroll;
	margin-top: 5px;
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
div > ::-webkit-scrollbar-button {
      scrollbar-color: red;  
      border-radius: 50px;  
}
::-webkit-scrollbar {
    width: 12px;
}

/* Track */
div > ::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
    -webkit-border-radius: 10px;
    border-radius: 10px;
    
}

/* Handle */
div > ::-webkit-scrollbar-thumb {
  border-radius: 50px;   
    height: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
    background: #76C893;
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
}

::-webkit-scrollbar-thumb {
  border-radius: 50px;   
    
    -webkit-border-radius: 10px;
    border-radius: 10px;
    
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
}

</style>