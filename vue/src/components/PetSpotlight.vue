<template>
  <div class="pet-spotlight-container">
      <div class="img-left">
        <img src="../assets/images/caitosdog.jpg" alt="">  
      </div>
      
      <div class="img-center">
        <img src="../assets/images/nicholasdog.jpg" alt="">  
      </div>
      <div class="img-right">
       <img src="../assets/images/stockcuteturtle.jpg" alt="">   
      </div>
      
      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->
</div>
</template>

<script>
export default {
    name: 'pet-spotlight',
}
</script>

<style scoped>
img {
    width: 10rem;
}

.pet-spotlight-container {
    margin-top: 5rem;
    display: flex;
    background-color: orange;
    justify-content: space-around;

}
</style>