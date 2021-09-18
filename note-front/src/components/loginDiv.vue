<template>
    <!-- 登录div -->
    <div style="margin-bottom: 10px;">Welcome {{isLogin?username:"Guest,want to login(y/n)?"}}
        <button @click="showLogin=true" class="smallFont" v-if="!isLogin">y</button>
        <button @click="logout" class="smallFont" v-if="isLogin">logOut</button>
        <div v-show="showLogin">
            <div style="margin-bottom: 10px;">Note Management login:<input type="text" v-model="userInput" ></div>
            <div style="margin-bottom: 10px;">password:<input type="password" v-model="passInput"></div>
            <button class="smallFont" @click="confirm">confirm</button>
            <button class="smallFont" @click="showLogin=false">cancel</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "loginDiv",
        data() {
            return {
                userInput: '',
                passInput: '',
                showLogin: false
            }
        },
        computed: {
            username: function() {
                return this.$store.state.user.username;
            },
            isLogin: function() {
                return this.username != null;
            }
        },
        methods: {
            confirm: function() {
                try {
                    let user = {'username' : this.userInput, 'password' : this.passInput};
                    let that = this;
                    this.$store.dispatch('user/login', user).then(() => {
                        that.showLogin = false;
                    });
                } catch (err) {
                    alert(err);
                }
            },
            logout: function() {
                this.$store.commit('user/SET_USERNAME', null);
            }
        }
    }
</script>

<style scoped>

</style>