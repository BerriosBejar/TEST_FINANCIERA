import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EmbeddedDataVenta, EmbeddedDataClientes, EmbeddedDataSubDetail} from 'src/app/interfaces/ventas/ventas.interface';

@Injectable({
  providedIn: 'root'
})
export class VentasService {

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private httpClient: HttpClient) { }

  public getDetailVentas(filterDate:any): Observable<EmbeddedDataVenta>
  {
    return this.httpClient.get<EmbeddedDataVenta>("http://localhost:9090/api/ventas/detail/?filterDate="+filterDate);
  }

  public getDataClient(idCliente:any): Observable<EmbeddedDataClientes>
  {
    return this.httpClient.get<EmbeddedDataClientes>("http://localhost:9090/api/clientes/"+idCliente);
  }

  public getSubDetailVentas(idVenta:any): Observable<EmbeddedDataSubDetail>
  {
    return this.httpClient.get<EmbeddedDataSubDetail>("http://localhost:9090/api/DetalleVentas/full-detalle-venta/"+idVenta);
  }
}
