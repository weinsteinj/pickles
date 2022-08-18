<template>
<body>
  <div class="app-intro-container">
      <h2>{{introHeader}}</h2>
      <h3>{{introSubHeader}}</h3>
      <p>{{introDescription}}</p>
  </div>    
</body>
  


      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->

</template>

<script>

export default {
    name: 'app-intro',
    data () {
        return {
            introHeader: 'Welcome to Pickles!',
            introSubHeader: 'Find the perfect pet playmate for your precious pet pals (please)!',
            introDescription: "Socialization is vital to your pet's quality of life but finding a playdate can be easier said than done. Whether it be dealing with scheduling conflicts, finding a pet pal that is compatible with your fur-baby, or your loved ones simply do not have pets for yours to play with. With Pickles we want to make that task stress free so you can focus on having fun with your animals. Pickles will help you find playdates in your area, schedule with other pet-parents, or create your own playdate to invite others to. Let us help you maximize your pet's fun with ease!"

        }
    }

    
}
</script>

<style scoped>
img {
    height: 10rem;
    max-width: 10rem;
}
.app-intro-container[data-v-7c98290a] {
    margin: .25rem 1rem 1rem 1rem;
}
.app-intro-container {
    padding: 5px;
    margin-top: 5rem;
    display: flex;
    flex-direction: column;
    background-color: #ced8df;
    /* justify-content: space-around; */
    border-radius: 15px 15px 15px 15px;
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
    margin: 1rem 1rem 1rem 1rem;
    height: 10rem;
    
}
.app-intro-container p {
    color: navy;
}

h2 {
    /* display: inline-block; */
    text-align: center;
    margin: 0px;

}
h3 {
    margin: 0px;
    text-align: center;
}



.app-intro-container:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
  
}

body {
    margin: 0;
    padding-top: 1rem;
}
</style>