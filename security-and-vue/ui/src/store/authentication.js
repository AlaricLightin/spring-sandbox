import axios from 'axios'
import VueCookies from 'vue-cookies'

const state = {
    authenticated: false,
    username: ''
}

const getters = {}

const actions = {
    authenticate({commit}, payload) {
        const data =
            'username=' +
            encodeURIComponent(payload.username) +
            '&password=' +
            encodeURIComponent(payload.password) +
            '&remember-me=true' +
            // this.rememberMe +
            '&submit=Login';

        return axios
            .post('/authentication', data, {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
            })
            .then(r => commit('SET_AUTHENTICATED', !!r.data.user))
            .catch(() => commit('SET_AUTHENTICATED', false));
    },

    logout({commit}) {
        return axios
            .post('logout', {})
            .finally(() => commit('SET_AUTHENTICATED', false));
    },

    retrieveUser({commit}) {
        const token = VueCookies.get('JSESSIONID') || VueCookies.get('XSRF-TOKEN');
        if (token)
            return axios
                .get('/user')
                .then(r => commit('SET_AUTHENTICATED', !!r.data.principal));
    }
}

const mutations = {
    SET_AUTHENTICATED(state, value) {
        state.authenticated = value;
    }
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}