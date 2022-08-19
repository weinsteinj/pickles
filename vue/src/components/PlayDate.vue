<template>
  <div>
      <div id = "app">
         <h1>Check out our current Playdates</h1>
        <div class ="scroll">
         
        <playdate-card v-for="playdate in filteredPlaydateArray" v-bind:key="playdate.id" 
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
  
  created () {},
  data () {
    return {
    
    }
  },
  computed: {
    filteredPlaydateArray() {
      if(this.$store.state.token == '') {
        return this.$store.state.playdateArray;
      } else {
      return this.$store.state.playdateArray.filter(p => p.zipCode > (this.$store.state.user.zipCode-200) && p.zipCode < (this.$store.state.user.zipCode+200));
      }
    },
  },
  methods: {
    scrollToEnd() {
				var container = document.querySelector(".scroll");
				var scrollHeight = container.scrollHeight;
				container.scrollTop = scrollHeight;
			},
  }
}
</script>

<style >
body {
    overflow-x: hidden;
}
</style>

<style scoped>

h1 {
  font-size: 25px;
  padding: 5px;
  margin: 0px;
  text-align: center;
  background: #52B69A;
  border-radius: 10px 10px 0px 0px;
}
.scroll{
  overflow-x: hidden;
	height: 34.5vh;
	overflow-y: scroll;

	margin-bottom: 20px;
  border-radius: 10px;
}

body {
  padding-top: 0rem;
  padding-bottom: 5px;
}

#scroll > body {
  padding-top: 0px;
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