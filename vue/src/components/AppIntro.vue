<template>
<body>
  <div class="app-intro-container">
      <h2>{{introHeader}}</h2><p>{{introDescription}}</p>
  </div>    
</body>
  


      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->

</template>

<script>

export default {
    name: 'app-intro',
    data () {
        return {
            introHeader: 'Welcome to Pickles! Find the perfect pet playmate for your precious pet pals (please)!',
            introDescription: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Aspernatur dignissimos omnis quidem ut,' 
            + 'odit aliquid esse voluptates sequi ipsum veniam vitae, sint unde. Voluptates repellendus, magni porro distinctio'
             + 'praesentium dolor!'
        }
    }

    
}
</script>

<style scoped>
img {
    height: 10rem;
    max-width: 10rem;
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
    margin: 5rem 1rem 0 1rem;
    height: 15rem;
    
}
.app-intro-container p {
    color: navy;
}

h2 {
    /* display: inline-block; */
    text-align: left;
}



.app-intro-container:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
  
}
</style>