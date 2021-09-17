<template>
  <div>
    <table class="item" v-for="node in nodes" :key="node.name">
    <tr>
      <td>
        {{node.dir?'文件夹':文件}}
      </td>
      <td>
        {{node.name}}
      </td>
    </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'list',
  data() {
    return {
        nodes : [{"address":"/nginx/负载均衡实现.md","dir":false,"name":"负载均衡实现.md"},{"address":"/nginx/url.txt","dir":false,"name":"url.txt"},{"address":"/nginx/note.md","dir":false,"name":"note.md"},{"address":"/nginx/test","dir":true,"name":"test"}],
    }
  }
}
</script>
<style type="text/css">
</style>
