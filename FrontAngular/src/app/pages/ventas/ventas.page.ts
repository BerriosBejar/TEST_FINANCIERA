import { Component, OnInit } from '@angular/core';
import { VentasService } from 'src/app/services/ventas/ventas.services';
import { Venta, Cliente, SubDetail } from 'src/app/interfaces/ventas/ventas.interface';


@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.page.html',
  styleUrls: ['./ventas.page.css']
})
export class VentasPage implements OnInit {

  fechaSeleccionada: string = '';
  fechaPopup: string = '';
  totalPopup: string = '';
  fechaPopupDisabled: boolean = true;
  showPopup:boolean = false;
  popupTitle:string = "Detalle de Venta";
  dataVenta: Venta[] = [];
  cliente!: Cliente;
  subDetail!: SubDetail[];


  handleClick(id_venta:any, id_cliente:any, fecha:any, total:any) {
    console.log("id_venta", id_venta)
    console.log("id_cliente", id_cliente)
    console.log("fecha", fecha)
    console.log("total", total)
    this.ventasService.getDataClient(id_cliente).subscribe(
      (data) => {
        console.log("data",data._embedded)
        this.cliente = data._embedded;
      }
    )
    this.ventasService.getSubDetailVentas(id_venta).subscribe(
      (data) => {
        console.log("data SUBDETAIL",data._embedded)
        this.subDetail = data._embedded;
      }
    )

    this.fechaPopup = fecha;
    this.totalPopup = total;

    this.showPopup = true;

  }

  closePopup() {
    this.showPopup = false;
  }

  buscar() {
    console.log('Fecha seleccionada:', this.fechaSeleccionada);
    this.ventasService.getDetailVentas(this.fechaSeleccionada).subscribe(
      (data) => {
        console.log("data",data._embedded)
        this.dataVenta = data._embedded;
      }
    )
  }

  constructor(private ventasService: VentasService) {}




  ngOnInit(): void {

    this.ventasService.getDetailVentas(this.fechaSeleccionada).subscribe(
      (data) => {
        console.log("data",data._embedded)
        this.dataVenta = data._embedded;
      }
    )


  }

}
