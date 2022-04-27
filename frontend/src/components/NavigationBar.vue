<template>
    <nav>
        <dropDown title="Variabels" :items="variabels"/>
        <div class="menu-item"><a href="#">Average</a></div>
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
           variabels: [
            {
               title: 'CGM',
               link: '#'
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
           ]
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