// Given two strings, write a function to determine if the second string is an anagram of the first. An anagram is a word, phrase or name formed by rearranging the letters of the another. 
//eg cinema - iceman
console.log(checkAnagram('','')); // true
console.log(checkAnagram('aaz','zza')); //false
console.log(checkAnagram('anagram','nagaram')); //true
console.log(checkAnagram('rat','car')); //false
function checkAnagram(str1, str2){
    if(str1 === '' && str2 === ''){
        return true;
    }
    let arr1 = str1.split('');
    let arr2 = str2.split('');
    const freqCounter1 = {};
    const freqCounter2 = {};
    if(arr1.length !== arr2.length){
        return false;
    }
    for(val of arr1){
        freqCounter1[val] = (freqCounter1[val] || 0) + 1;
    }
    for(val of arr2){
        freqCounter2[val] = (freqCounter2[val] || 0) + 1;
    }
    for(element of arr1) {
        if(!(element in freqCounter2)){
            return false;
        }
        if(freqCounter1[element] !== freqCounter2[element]){
            return false;
        }
    }
    return true;
}