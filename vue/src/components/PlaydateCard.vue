<template>
    <body>
        <h2> Host: {{playdate.hostUsername}}  
        </h2>
        <h3>
            Playdate ZipCode: {{playdate.zipCode}}
            </h3>
            <div>
            Pets: 
            {{pets.join(', ')}}
        </div>
            <div>
            Species:
            {{species.join(', ')}}
            </div>
        <router-link class="router-link" :to="{path: '/playdate/'+playdate.playdateId}"> See more details! </router-link>
    </body>
</template>

<script>
export default {
    name: 'playdate-card',
    data() {
        return {
            pets: [],
            species: []
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
               
                    if (element === petIdHere) {
                    this.pets.push(pet.name)
                    this.species.push(pet.species);
                    }
                    
                     })
                })
            this.pets = this.pets.filter(unique);  
            this.species = this.species.filter(unique);  
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

<style scoped>
h2 {
    display: flex;
    font-size: 22px;
    text-decoration: underline;
    margin-bottom: 0px;
    padding-top: 0px;
    text-align: top;
    justify-content: center;

}
h3 {
    margin: 0px;
}
body {
    text-align: center;
    padding-top: 0px;
    margin-top: 0px;

}

.router-link {
    text-decoration: none;
    color: var(--primary-green);
}
</style>