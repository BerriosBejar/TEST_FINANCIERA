// popup.component.ts
import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent {
  @Input() title: string = '';
  @Output() closed = new EventEmitter();

  closePopup(event: Event) {
    const target = event.target as HTMLElement;
    if (target.classList.contains('close-btn')) {
      this.closed.emit();
    }
  }
}
