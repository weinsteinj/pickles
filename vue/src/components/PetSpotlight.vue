<template>
<body>
  <div class="pet-spotlight-container">
      <div class="flexslider" style="direction:rtl">
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
</body>
  


      <!-- <router-link :to="{/* TODO - Links to Registration */}" >Join us (tbd)</router-link> -->

</template>

<script>
const $ = window.$;
export default {
    name: 'pet-spotlight',

    mounted() {
      let recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', 'https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js')
      document.head.appendChild(recaptchaScript)

      $('.flexslider').flexslider();
    }
}
</script>

<style scoped>
img {
    height: 10rem;
    max-width: 10rem;
}



.pet-spotlight-container {
    margin-top: 5rem;
    display: flex;
    background-color: #184E77;
    justify-content: space-around;
    border-radius: 15px 15px 15px 15px;
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.18);
    margin: 5rem 1rem 0 1rem;
    height: 15rem;
  
}

.flex-control-paging li a {
  text-indent: 0px;
  display: none;
}

.pet-spotlight-container:hover {
  box-shadow: 0 10px 10px rgba(0, 0, 0, 0.18);
  
}

 /* {
  margin-right: ;
} */
</style>