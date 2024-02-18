export interface Venta {
  id: number;
  id_cliente: number;
  nombres: string;
  apellidos: string;
  fecha: string;
  total: number;
}

export interface EmbeddedDataVenta {
  _embedded: Venta[];
}


export interface Cliente {
  id: number;
  nombres: string;
  apellidos: string;
  dni: string;
  telefono: string;
  email: string;
}

export interface EmbeddedDataClientes {
  _embedded: Cliente;
}


export interface SubDetail {
  nombre: number;
  precio: string;
  cantidad: string;
  subtotal: string;
}

export interface EmbeddedDataSubDetail {
  _embedded: SubDetail[];
}


