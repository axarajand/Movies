Aplikasi untuk menampilkan list dan detail dari film.

Architecture Component
  * ViewModel
  * Repository
  * LiveData
  * Room
  * Pagination

Halaman
  * Daftar film
    * Terdapat 2 (dua) halaman yang menampilkan daftar film (Movies dan TV Show).
    * Menerapkan ViewModel, LiveData dan Repository.

  * Detail film
    * Menampilkan poster dan informasi film pada halaman detail film.
    * Menerapkan ViewModel, LiveData dan Repository.

  * Favorite Film
    * Dapat menyimpan film ke database favorite.
    * Dapat menghapus film dari database favorite.
    * Terdapat halaman untuk menampilkan daftar Favorite Movies.
    * Terdapat halaman untuk menampilkan daftar Favorite TV Show.
    * Menerapkan Room menyimpan data Favorite Movie dan Favorite TVShow.
    * Menerapkan Pagination untuk mengatur data pada RecyclerView.

  * Unit Test
    * Menerapkan unit test pada semua fungsi yang digunakan untuk mendapatkan data Movie dan TV Show.

  * Instrumentation Test
    * Menerapkan instrumentation test untuk memastikan fitur-fitur yang ada berjalan dengan semestinya.
    * Menerapkan Idling Resouces untuk menangani asynchronus proses saat Instrumental Testing

Berikut testing yang dijalankan : 

  * Unit Testing

    * MovieViewModelTest
      * Memanipulasi data ketika pemanggilan data movie di kelas repository
      * Memastikan metode di kelas repository terpanggil
      * Memastikan data movie tidak null
      * Memastikan jumlah data movie sesuai dengan harapan

    * TVShowViewModelTest
      * Memanipulasi data ketika pemanggilan data series di kelas repository
      * Memastikan metode di kelas repository terpanggil
      * Memastikan data series tidak null
      * Memastikan jumlah data series sesuai dengan harapan

    * FavoriteViewModelTest
      * Memanipulasi data ketika pemanggilan data series di kelas repository
      * Memastikan metode di kelas repository terpanggil
      * Memastikan data series tidak null
      * Memastikan jumlah data series sesuai dengan harapan

    * DetailMovieViewModelTest
      * Memanipulasi data ketika pemanggilan data movie di kelas repository
      * Memastikan metode di kelas repository terpanggil
      * Memastikan data movie tidak null
      * Memastikan data movie sesuai dengan harapan

    * DetailSeriesViewModelTest
      * Series
        * Memanipulasi data ketika pemanggilan data series di kelas repository
        * Memastikan metode di kelas repository terpanggil
        * Memastikan data series tidak null
        * Memastikan data series sesuai dengan harapan
      * Episodes
        * Memanipulasi data ketika pemanggilan data episode di kelas repository
        * Memastikan metode di kelas repository terpanggil
        * Memastikan data episode tidak null
        * Memastikan jumlah data episode sesuai dengan harapan

    * SeriesReaderViewModelTest
      * Episodes
        * Memanipulasi data ketika pemanggilan data episode di kelas repository
        * Memastikan metode di kelas repository terpanggil
        * Memastikan data episode tidak null
        * Memastikan jumlah data episode sesuai dengan harapan
      * Content Episode
        * Memanipulasi data ketika pemanggilan data content di kelas repository
        * Memastikan metode di kelas repository terpanggil
        * Memastikan data episode tidak null
        * Memastikan data content tidak null
        * Memastikan value dari content tidak null 
        * Memastikan jumlah data episode sesuai dengan harapan
        * Memastikan data content sesuai dengan yang diharapkan 


  * Instrumental Testing

    * Menampilkan data Movie
      * Memastikan rv_movie dalam keadaan tampil
      * Gulir rv_movie ke posisi data terakhir

    * Menampilkan data detail Movie
      * Memastikan rv_movie dalam keadaan tampil
      * Memberi tindakan klik pada data pertama di rv_movie

      * Memastikan tv_title_movie dalam keadaan tampil
      * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan

      * Memastikan tv_description_movie dalam keadaan tampil
      * Memastikan TextView untuk description tampil sesuai dengan yang diharapkan

      * Memastikan tv_genres_movie dalam keadaan tampil
      * Memastikan TextView untuk genres tampil sesuai dengan yang diharapkan

      * Memastikan tv_realese_movie dalam keadaan tampil
      * Memastikan TextView untuk realese tampil sesuai dengan yang diharapkan

      * Memastikan tv_rating_movie dalam keadaan tampil
      * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan

      * Menampilkan data TV Show (Series)
      * Memastikan navigation_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada navigation_tvshow 

      * Memastikan rv_tvshow dalam keadaan tampil
      * Gulir rv_tvshow ke posisi data terakhir

    * Menampilkan data detail TV Show (Series)
      * Memastikan navigation_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada navigation_tvshow

      * Memastikan rv_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada btn_item_read_tvshow  dan data pertama di rv_tvshow 

      * Memastikan tv_title_series  dalam keadaan tampil
      * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan

      * Memastikan tv_description_series  dalam keadaan tampil
      * Memastikan TextView untuk description tampil sesuai dengan yang diharapkan

      * Memastikan tv_genres_series  dalam keadaan tampil
      * Memastikan TextView untuk genres tampil sesuai dengan yang diharapkan

      * Memastikan tv_realese_series  dalam keadaan tampil
      * Memastikan TextView untuk realese tampil sesuai dengan yang diharapkan

      * Memastikan tv_rating_series  dalam keadaan tampil
      * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan

    * Menampilkan data Episode
      * Memastikan navigation_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada navigation_tvshow

      * Memastikan rv_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada btn_item_read_tvshow  dan data pertama di rv_tvshow

      * Memastikan btn_start_series dalam keadaan tampil
      * Memberi tindakan klik pada btn_start_series

      * Memastikan rv_episode dalam keadaan tampil
      * Gulir rv_episode ke posisi data terakhir

    * Menampilkan data content Episode
      * Memastikan navigation_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada navigation_tvshow

      * Memastikan rv_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada btn_item_read_tvshow  dan data pertama di rv_tvshow

      * Memastikan btn_start_series dalam keadaan tampil
      * Memberi tindakan klik pada btn_start_series

      * Memastikan rv_episode dalam keadaan tampil
      * Memberi tindakan klik pada data pertama di rv_episode

      * Memastikan web_view sudah tampil

    * Menampilkan data Favorite
      * Memastikan navigation_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada navigation_tvshow

      * Memastikan rv_tvshow dalam keadaan tampil
      * Memberi tindakan klik pada btn_item_read_tvshow  dan data pertama di rv_tvshow

      * Memberi tindakan klik pada action_favorite
      * Memberi tindakan menekan tombol kembali

      * Memastikan rv_favorite dalam keadaan tampil
      * Memberi tindakan klik pada btn_item_read_favorite  dan data pertama di rv_favorite

      * Memastikan tv_title_series  dalam keadaan tampil
      * Memastikan TextView untuk title tampil sesuai dengan yang diharapkan

      * Memastikan tv_description_series  dalam keadaan tampil
      * Memastikan TextView untuk description tampil sesuai dengan yang diharapkan

      * Memastikan tv_genres_series  dalam keadaan tampil
      * Memastikan TextView untuk genres tampil sesuai dengan yang diharapkan

      * Memastikan tv_realese_series  dalam keadaan tampil
      * Memastikan TextView untuk realese tampil sesuai dengan yang diharapkan

      * Memastikan tv_rating_series  dalam keadaan tampil
      * Memastikan TextView untuk rating tampil sesuai dengan yang diharapkan

      * Memberi tindakan klik pada action_favorite
      * Memberi tindakan menekan tombol kembali

