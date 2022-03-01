<template>
  <div>
    <h2>List of patients</h2>
    <ul>
       <li
        v-bind:key="h.id"
        v-for="h in hospitals">
        {{ h.name }}
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'ListHospital',
  props: ['hospitals']
}
</script>


