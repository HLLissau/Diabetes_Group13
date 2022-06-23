<template>
    <!-- Erik s204438 -->
    <div class="menu-item" @click="isOpen = !isOpen">
      <a class="title">
          {{ title }}
      </a>
      <div class="svg-scale">
        <svg viewBox="0 0 1030 638" width="10">
            <path d="M1017 68L541 626q-11 12-26 12t-26-12L13 68Q-3 49 6 24.5T39 0h952q24 0 33 24.5t-7 43.5z" fill="#FFF"></path>
        </svg>
      </div>
      
    <transition name="fade" appear>  
        <div class="sub-menu" v-if="isOpen">
            <div v-for="(item,i) in items" :key="i" class="sub-menu-item">
              <a @click=choice(item)>{{ item.title }}</a> 
            </div>
        </div>
    </transition>
    </div>    
</template>

<script>
import '../Styling/DropDownMenuStyling.css'

export default {
    name: 'dropDown',
    props: ['title','items'],
    data () {
        return {
            isOpen: false
        }
    },
    methods: {
      choice(item){
        this.$emit('child-choice',item.title)
      }
    }
}
</script>

<style>
.svg-scale {
  padding-left: 0.1vw;
  max-width: 3vw;
}
</style>