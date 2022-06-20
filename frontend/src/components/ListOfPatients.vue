<template>
<div>
    <h2> List of Current Patients</h2>
    <ul>
        <dropdown
  title="Simple Filter"
  text="Click to filter"
  :items="ListPatients.fullName">
</dropdown>
        <li
        v-bind:key="p.id"
        v-for="p in ListPatients"   
        >{{p.fullName}}
        </li>
      

    </ul>
</div>
</template>


<script>
   export default {
    component : { },
    name: 'listOfPatients',
    props: ['ListPatients']
   }
</script>