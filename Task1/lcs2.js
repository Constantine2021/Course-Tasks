function lcs(strings)
{
    let shortest = strings.reduce((a, b) => a.length <= b.length ? a : b);
    let maxlen = shortest.length;
    for (let len = maxlen; len >= 0; len--)
    {
        for (let start = 0; start <= maxlen - len; start++)
        {       
            let substr = shortest.substring(start, len+start);
            if (strings.every(elem => ~elem.indexOf(substr))) {return substr;}
        }
    }
    return '';
}
 
if (process.argv.length < 3)
    console.log('');
else
    console.log(lcs(process.argv.slice(2)));

    /*while(undefined){
        console.log(process.argv.slice(2));
        break;
    }*/

   // console.log(lcs(['ABCQEFDEFGHIJ', 'BCXEFGYZBCDEWEFGHU']));