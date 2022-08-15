<template>
    <body>
        <h2> Host User ID: {{playdate.hostUserId}}  
        </h2>
        <h3>
            Playdate ZipCode: {{playdate.zipCode}}
            </h3>
            <div>
            Pets: 
            {{pets.join(', ')}}
        </div>
            </body>
</template>

<script>
export default {
    name: 'playdate-card',
    data() {
        return {
            pets: []
        }
    },
    props: {
        playdate: Object,
    },
    created() {
        const unique = (value, index, self) => {
        return self.indexOf(value) === index
    }
    
        let allPetsArray = this.$store.state.petArray;
        let playdatePets = this.playdate.petId;
        
        for(let i=0; i<allPetsArray.length; i++) {
            
            playdatePets.forEach((element) => {
                
                allPetsArray.forEach(pet => {
                    let petIdHere = pet.petId;
               
                    if (element === petIdHere)
                    this.pets.push(pet.name)
                    
                     })
                })
            this.pets(unique);  
        }
            
        
    },

    methods: {
        getNamesFromId(id){
            this.$store.state.petArray.find(element => {
                element.id === id;
            })
        }
    }
}
</script>

<style>
h2 {
    font-size: 22px;
    text-decoration: underline;
    margin-bottom: 0px;
}
h3 {
    margin: 0px;
}
body {
    text-align: center;
}
</style>