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
    background-color: #184E77;
    justify-content: space-around;
    border-radius: 15px 15px 15px 15px;
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
    margin: 5rem 1rem 0 1rem;

}
</style>