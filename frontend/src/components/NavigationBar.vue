<template>
    <nav>
        <dropDown title="Variable" :items="variabels" @child-choice="updateChoice"/>
        <dropDown title="Interval" :items="interval" @child-choice="updateChoice"/>
        <div class="menu-item" v-on:click="Average()" ><a class="title"> Average</a></div>
    </nav>
</template>

<script>
import '../Styling/DropDownNavbarStyling.css'
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
            this.updateChoice(this.average)
            console.log("button average",this.average)
        },
        mounted(){
            this.average = false
            this.interval = 'Day'
        
        }

    }
}
</script>