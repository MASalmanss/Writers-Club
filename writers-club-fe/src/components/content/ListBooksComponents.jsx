import React, { useEffect, useState } from 'react';
import axios from "axios";

function ListBooksComponent() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    // API'den veri çekme
    axios.get("http://localhost:1111/api/books")
      .then((result) => {
        setBooks(result.data);
        console.log(result.data);
      })
      .catch((e) => {
        console.error(e);
      });
  }, []); // Bağımlılık dizisi boş, bu sayede useEffect sadece bileşen ilk yüklendiğinde çalışır.

  return (
    <div className='container mt-4'>
      <div className='row'>
        {
          books.map((book, index) => (
            <div className='col-md-4 mb-4' key={index}>
              <div className='card'>
                <div className='card-body'>
                  <div className='card-title'>
                    {book.title}
                  </div>
                  <div className='card-text'>
                    {book.description}
                  </div>
                  <a href="#" className='btn btn-primary'>Detalar</a>
                </div>
              </div>
            </div>
          ))
        }
      </div>
    </div>
  );
}

export default ListBooksComponent;
