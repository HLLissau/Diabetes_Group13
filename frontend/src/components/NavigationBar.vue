<template>
    <nav>

        <dropDown title="Variable" :items="variabels" v-on:child-choice="updateChoice"/>
        <dropDown title="Interval" :items="interval" v-on:child-choice="updateChoice"/>
        <div class="menu-item"><a href="#"> Average</a></div>
        
        <div class="menu-item"><a href="#">Settings</a></div>
    </nav>
</template>

<script>
import dropDown from './DropDownMenu'
export default {
    name: 'navigationBar',
    components: {
        dropDown
    },
    data () {
        return {

           //variableChoice : "",
           //invervalChoice : "",

           variabels: [
            {
               title: 'measurement',
               link: '#'

           },
           {
               title: 'meals',
               link: '#'
           },
           {
               title: 'exercise',
               link: '#'
           },
           {
               title: 'basal',
               link: '#'
           },
           {
               title: 'bolus',
               link: '#'
           }
           ],
           interval: [
            {
               title: 'Day',
               link: '#'

           },
           {
               title: 'Week',
               link: '#'
           },
           {
               title: 'Month',
               link: '#'
           },
           {
               title: 'Year',
               link: '#'
           },
           {
               title: 'All time',
               link: '#'
           }
           ],
           //variabel: 'test',
           
        }
    },

    methods: {
        Settings(){
            console.log()
        },
        Average(){
            console.log()
        },
        updateChoice(choice_from_child){
            console.log("Navigationbaremit", choice_from_child)
            this.$emit('child-choice',choice_from_child)
        }

    }
}
</script>

<style>
nav {
  display: flex;
  align-items: center;
  justify-content: center;
}
nav .menu-item {
  color: #FFF;
  padding: 10px 20px;
  position: relative;
  text-align: center;
  border-bottom: 3px solid transparent;
  display: flex;
  transition: 0.4s;
}
nav .menu-item.active,
nav .menu-item:hover {
  background-color: #444;
  border-bottom-color: #FF5858;
}
nav .menu-item a {
  color: inherit;
  text-decoration: none;
}
</style>