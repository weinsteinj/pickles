<template>
<body>
  <!-- <div class="pet-spotlight-container"> -->
      <div class="flexslider carousel" >
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
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
            <li>
              <img class="img-left" src="../assets/images/caitosdog.jpg" />
            </li>
            <li>
              <img class="img-center" src="../assets/images/nicholasdog.jpg" />
            </li>
            <li>
              <img class="img-right" src="../assets/images/stockcuteturtle.jpg" />
            </li>
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
  <!-- </div>     -->
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

      $('.flexslider').flexslider({
     animation: "slide",
    animationLoop: true,
    itemWidth: 40,
    itemMargin: 5,
    minItems: 4,
    maxItems: 4,
    slideshow: true,                //Boolean: Animate slider automatically
    slideshowSpeed: 7000,           //Integer: Set the speed of the slideshow cycling, in milliseconds
    animationSpeed: 600,   
    randomize: true
    
  });
    }
}
</script>

<style scoped>



img {
    height: 230px;
    width: 280px;
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



.slides {
  background: none;
}

 img {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  object-fit: cover;
  justify-content: center;
  align-items: center;
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 2px;
  padding-right: 2px;
}

.flexslider {
  background: none; 
  margin: 0px;
  border: none;
}



 /* {
  margin-right: ;
} */
</style>