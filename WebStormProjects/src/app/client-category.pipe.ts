import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'clientCategory'
})
export class ClientCategoryPipe implements PipeTransform {

  transform(ca: number, args?: string): string {
    if (ca < 0) {
      if (args === 'string') {
        return 'Client en négatif';
      } else {
        return 'red';
      }
    } else if (ca > 0) {
      if (args === 'string') {
        return 'Client en positif';
      } else {
        return 'green';
      }
    } else {
      if (args === 'string') {
        return 'Client neutre';
      } else {
        return 'blue';
      }
    }

  }

}
