<template>
    <div class="col-md-1" style="font-size: 30px;">
        >_:
    </div>
    <div class="col-md-10">
        <LoginDiv></LoginDiv>
        <router-view></router-view>
    </div>
    <div class="col-md-1"></div>
</template>

<script>
    import LoginDiv from "@/components/loginDiv";
    export default {
        name: "layout",
        components: {
            LoginDiv
        }
    }
</script>

<style>
</style>