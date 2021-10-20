import axios from 'axios'

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