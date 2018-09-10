import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'clientCategoryPipe'
})
export class ClientCategoryPipePipe implements PipeTransform {

  transform(ca: number, arg0?: string): string {
    if (arg0) {
      if (ca < 0) {
        return 'Client en negatif: ';
      } else if (ca > 0) {
        return 'Client en positif: ';
      } else {
        return 'Client neutre: ';
      }
    } else {
      if (ca < 0) {
        return 'red';
      } else if (ca > 0) {
        return 'green';
      } else {
        return 'blue';
      }
    }

  }

}
