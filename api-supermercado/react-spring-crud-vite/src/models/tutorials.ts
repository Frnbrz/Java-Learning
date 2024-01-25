export interface ProductModel {
  idproducto: number
  nombre: string
  categoria: CategoriaModel
  medida: string
  precio: number
  stock: number
  status: boolean
}



export interface CategoriaModel {
  idcategoria: number
  categoria: string
}
