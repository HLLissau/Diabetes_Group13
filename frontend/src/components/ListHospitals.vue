<template>
  <div>
    <h2>Users</h2>
    <ul>
       <li
        v-bind:key="h.id"
        v-for="h in hospitals">
        {{ h.name }} -
        <!--<router-link :to="{ name: 'ListPatients', params: { id: h.id, patients: h.patients } }">Patients list</router-link>-->
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'ListHospitals',
  props: ['hospitals']
}


</script>