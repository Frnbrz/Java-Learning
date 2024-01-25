
import { ProductModel } from '../../models/tutorials'
import http from '../axios'

const API_URL = '/productos'

const getAll = () => {
  return http.get(API_URL)
}

const get = (id: number) => {
  return http.get(`${API_URL}/${id}`)
}

const create = (data: ProductModel) => {
  return http.post(API_URL, data)
}

const update = (id: number, data: ProductModel) => {
  return http.put(`${API_URL}/${id}`, data)
}

const remove = (id: number) => {
  return http.delete(`${API_URL}/${id}`)
}

const removeAll = () => {
  return http.delete(API_URL)
}


const TutorialService = {
  getAll,
  get,
  create,
  update,
  remove,
  removeAll,
}

export default TutorialService
