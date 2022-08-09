<template>
  <div class="pet-spotlight-container">
      <div class="flexslider">
          <ul class="slides">
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
        </ul>
    </div>
  </div>    


      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->

</template>

<script>
export default {
    name: 'pet-spotlight',

    mounted() {
      let recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', 'https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js')
      document.head.appendChild(recaptchaScript)
    }
}
</script>

<style scoped>
img {
    width: 10rem;
}

.img-left,
.img-center,
.img-right {
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

.pet-spotlight-container:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
}
</style>