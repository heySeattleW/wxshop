const DATABASE_NAME = 'websql_cache'
const DATABASE_VERSION = '1.0'
const db = openDatabase(DATABASE_NAME, DATABASE_VERSION, 'CAHCE DB', 10 * 1024 * 1024);
db.transaction(function (tx) {
  tx.executeSql('CREATE TABLE IF NOT EXISTS KV_STORAGE (key, value, updatetime)');
})

export default {
  setItem:(key, _value) => new Promise((resolve, reject) =>{
    db.transaction(tx => {
      let value = _value
      if(value==undefined || value==null) resolve(false);
      if(typeof(value) != 'string'){
        value = JSON.stringify(value)
      }
      let timestamp=new Date().getTime()
      tx.executeSql('SELECT * FROM KV_STORAGE WHERE KEY = ?', [key], (tx, results)=>{
        let len = results.rows.length;
        if (len<1){
          tx.executeSql(`INSERT INTO KV_STORAGE (key,value,updatetime) VALUES ('${key}','${value}', ${timestamp})`);
        }else{
          tx.executeSql('UPDATE KV_STORAGE SET VALUE = ?',[value]);
        }
        resolve(true)
      })
    })
  }),
  getItem: (key) => new Promise((resolve, reject) =>{
    db.transaction(tx => {
      tx.executeSql("SELECT VALUE FROM KV_STORAGE WHERE KEY = ?", [key], (tx, results)=>{
        let len = results.rows.length;
        if(len<1){resolve(undefined)}
        resolve(results.rows[0].value)
      })
    })
  }),
  deleteItem: (key) => new Promise((resolve, reject) =>{
    db.transaction(tx => {
      tx.executeSql('DELETE FROM KV_STORAGE WHERE KEY = ?',[key]);
      resolve(true)
    })
  }),
  clear: () => new Promise((resolve, reject) =>{
    db.transaction(tx => {
      tx.executeSql('DELETE FROM KV_STORAGE');
      resolve(true)
    })
  })
}
