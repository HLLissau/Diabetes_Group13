<template>
    <nav>

        <dropDown title="Variable" :items="variabels" @child-choice="updateChoice"/>
        <dropDown title="Interval" :items="interval" @child-choice="updateChoice"/>
        <div class="menu-item" v-bind:style= "[this.average ? {'background-color': '#FF5858'} : {'background-color': '#222222'}]" v-on:click="Average()" ><a> Average</a></div>
        <div class="menu-item"><a >Settings</a></div>
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
            average: false,
           //variableChoice : "",
           //invervalChoice : "",

           variabels: [
            {
               title: 'measurement',
           },
           {
               title: 'meals',
           },
           {
               title: 'exercise',
           },
           {
               title: 'basal',
           },
           {
               title: 'bolus',
           }
           ],
           interval: [
            {
               title: 'Day',

           },
           {
               title: 'Week',
           },
           {
               title: 'Month',
           },
           {
               title: 'Year',
           },
           {
               title: 'All time',
           }
           ],
           //variabel: 'test',
           
        }
    },

    methods: {
        Settings(){
            console.log()
        },
        updateChoice(choice_from_child){
            //console.log("Navigationbaremit", choice_from_child)
            this.$emit('child-choice',choice_from_child)
        },
        Average() {
            this.average = !this.average
            this.$emit('clicked', this.average)
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