import api from 'src/config/api'
import {$http} from 'src/extends/http'
import db from 'src/extends/websql'
export default {
  getAdderssPicker: async ({commit,state}) => {
    let addressPicker = state.addressPicker
    if(addressPicker.length < 1){
      let addressPicker = await db.getItem('addressPicker')
      commit('getAdderssPicker', JSON.parse(addressPicker))
    }
  },
  saveAddressPicker({commit},addressPicker) {
    commit('getAdderssPicker', addressPicker)
  },
  editAddress: ({commit},address) => {
      commit('editAddress', address)
  },
}

