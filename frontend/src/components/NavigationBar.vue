<template>
    <nav>
        <dropDown title="Variabels" :items="variabels"/>
        <div class="menu-item" ><a @click="toggle">{{isToggled ? 'ON' : 'OFF'}}</a></div>
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
           isToggled: false,
            //colorStyle:{
            //backgroundColor:"#16a085" 
            //},
           variabels: [
            {
               title: 'CGM',
               link: '#',

           },
           {
               title: 'Carbohydrate',
               link: '#'
           },
           {
               title: 'Exercise',
               link: '#'
           },
           {
               title: 'Basal',
               link: '#'
           },
           {
               title: 'Bolus',
               link: '#'
           }
           ],
           variabel: 'test',
           
        }
    },
     methods: {
       toggle() {
         this.isToggled = !this.isToggled
    },
        
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