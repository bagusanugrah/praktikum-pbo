import java.util.Scanner; // Import kelas Scanner dari paket java.util
import java.util.regex.Matcher; // Import kelas Matcher dari paket java.util.regex
import java.util.regex.Pattern; // Import kelas Pattern dari paket java.util.regex

class Nomor2 { // Mendefinisikan kelas Nomor2
    private static Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input dari pengguna

    public static void main(String[] args) { // Method utama untuk menjalankan program
        // Deklarasi variabel
        String pilihMenu;
        String namaInput;
        String emailInput;
        String passwordInput;
        String passwordConfirmation;
        String roleDipilih;
        String statusValidasi = "";
        boolean loginBerhasil;

        // Array untuk menyimpan data pengguna
        String[] role = new String[10];
        String[] nama = new String[10];
        String[] email = new String[10];
        String[] password = new String[10];
        int currentIndex = 0;

        while (true) { // Loop utama program
            roleDipilih = ""; // Reset role yang dipilih

            // Menampilkan menu
            System.out.println("Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Hentikan Program");
            System.out.print("Pilih menu [1/2/0]: ");
            pilihMenu = scanner.nextLine(); // Membaca input menu dari pengguna

            if (pilihMenu.equals("1")) { // Jika pengguna memilih register
                while (true) { // Loop untuk registrasi
                    roleDipilih = pilihRole(roleDipilih); // Memilih role

                    // Menampilkan form registrasi
                    System.out.println();
                    System.out.println("Register");
                    System.out.print("Nama: ");
                    namaInput = scanner.nextLine();
                    System.out.print("Email: ");
                    emailInput = scanner.nextLine();
                    System.out.print("Password: ");
                    passwordInput = scanner.nextLine();
                    System.out.print("Password Confirmation: ");
                    passwordConfirmation = scanner.nextLine();

                    // Memvalidasi input
                    statusValidasi = validasiInput(namaInput, emailInput, passwordInput, passwordConfirmation, roleDipilih, role, email);
                    if (statusValidasi.equals("tervalidasi")) { // Jika input valid
                        // Menyimpan data registrasi
                        nama[currentIndex] = namaInput;
                        role[currentIndex] = roleDipilih;
                        email[currentIndex] = emailInput;
                        password[currentIndex] = passwordInput;
                        currentIndex += 1; // Menambahkan indeks
                        System.out.println("Registrasi berhasil!"); // Menampilkan pesan berhasil
                        System.out.println();
                        break; // Keluar dari loop registrasi
                    } else { // Jika input tidak valid
                        System.out.println(statusValidasi); // Menampilkan pesan kesalahan
                    }
                }
            } else if (pilihMenu.equals("2")) { // Jika pengguna memilih login
                loginBerhasil = false; // Inisialisasi loginBerhasil ke false

                while (!loginBerhasil) { // Loop untuk login
                    roleDipilih = pilihRole(roleDipilih); // Memilih role

                    // Menampilkan form login
                    System.out.println();
                    System.out.println("Login");
                    System.out.print("Email: ");
                    emailInput = scanner.nextLine();
                    System.out.print("Password: ");
                    passwordInput = scanner.nextLine();

                    RegexValidator validator = new RegexValidator(emailInput, null); // Membuat objek validator

                    if (emailInput.equals("") || passwordInput.equals("")) { // Jika email atau password kosong
                        System.out.println("Email atau Password tidak boleh kosong!"); // Menampilkan pesan kesalahan
                    } else if (!validator.validasiEmail()) { // Jika email tidak valid
                        System.out.println("Inputan email tidak valid!"); // Menampilkan pesan kesalahan
                    } else { // Jika input valid
                        if (email[0] != null) { // Jika data pengguna tersedia
                            loginBerhasil = login(emailInput, passwordInput, roleDipilih, nama, role, email, password); // Melakukan login
                        } else { // Jika database kosong
                            System.out.println("Database masih kosong bjir...."); // Menampilkan pesan kosong
                            System.out.println();
                            break; // Keluar dari loop
                        }
                    }
                }
            } else if (pilihMenu.equals("0")) { // Jika pengguna memilih untuk menghentikan program
                break; // Keluar dari loop utama
            } else { // Jika input menu salah
                System.out.println("Inputan menu salah! Inputkan 1 untuk register, 2 untuk login, atau 0 (nol) untuk hentikan program"); // Menampilkan pesan kesalahan
                System.out.println();
            }
        }
    }

    // Method untuk melakukan login
    public static boolean login(String email, String password, String role, String[] arrayNama, String[] arrayRole, String[] arrayEmail, String[] arrayPassword) {
        // Deklarasi variabel
        String getNama = "";
        String getEmail = "";
        String getPassword = "";
        boolean berhasilLogin = false;

        // Loop untuk mencari data pengguna yang sesuai
        for (int i = 0; i < arrayRole.length; i++) {
            if (arrayRole[i] != null) { // Jika role tidak kosong
                if (arrayRole[i].equals(role)) { // Jika role sesuai
                    if (arrayEmail[i].equals(email)) { // Jika email sesuai
                        getEmail = arrayEmail[i]; // Menyimpan email pengguna
                        getPassword = arrayPassword[i]; // Menyimpan password pengguna
                        getNama = arrayNama[i]; // Menyimpan nama pengguna
                    }
                }
            }
        }

        if (getEmail.equals("")) { // Jika email tidak ditemukan
            System.out.println("Email " + email + " tidak terdaftar sebagai " + role); // Menampilkan pesan kesalahan
            System.out.println();
            berhasilLogin = true; // Set keberhasilan login menjadi true
        } else if (!getPassword.equals(password)) { // Jika password tidak sesuai
            System.out.println("Password yang anda masukkan salah!"); // Menampilkan pesan kesalahan
        } else { // Jika login berhasil
            if (role.equals("admin")) { // Jika role adalah admin
                System.out.println("Selamat datang admin " + getNama); // Menampilkan pesan selamat datang
                System.out.println();
            }
            if (role.equals("member")) { // Jika role adalah member
                System.out.println("Helo " + getNama + " status anda member"); // Menampilkan pesan selamat datang
                System.out.println();
            }
            berhasilLogin = true; // Set keberhasilan login menjadi true
        }

        return berhasilLogin; // Mengembalikan nilai keberhasilan login
    }

    // Method untuk melakukan validasi input registrasi
    public static String validasiInput(String nama, String email, String password, String pwdConfirm, String role, String[] arrayRole, String[] arrayEmail) {
        // Deklarasi variabel
        String hasilValidasi = "tervalidasi";
        String getEmail = null;
        RegexValidator validator = new RegexValidator(email, password); // Membuat objek validator

        if (nama.equals("") || email.equals("") || password.equals("") || pwdConfirm.equals("")) { // Jika ada field yang kosong
            hasilValidasi = "Nama, Email, Password, atau Password Confirmation tidak boleh ada yang kosong!"; // Menampilkan pesan kesalahan
        } else { // Jika semua field terisi
            if (!validator.validasiEmail()) { // Jika email tidak valid
                hasilValidasi = "Inputan email tidak valid!"; // Menampilkan pesan kesalahan
            } else { // Jika email valid
                for (int i = 0; i < arrayRole.length; i++) { // Looping untuk memeriksa email yang sudah terdaftar
                    if (arrayRole[i] != null) { // Jika role tidak kosong
                        if (arrayRole[i].equals(role)) { // Jika role sesuai
                            if (arrayEmail[i].equals(email)) { // Jika email sudah terdaftar
                                getEmail = arrayEmail[i]; // Menyimpan email yang sudah terdaftar
                            }
                        }
                    }
                }

                if (getEmail != null) { // Jika email sudah terdaftar
                    hasilValidasi = "Email " + email + " sudah terdaftar sebagai " + role; // Menampilkan pesan kesalahan
                } else { // Jika email belum terdaftar
                    if (!validator.validasiPassword()) { // Jika password tidak memenuhi kriteria
                        hasilValidasi = "Password harus lebih dari 8 karakter"; // Menampilkan pesan kesalahan
                    } else { // Jika password memenuhi kriteria
                        if (!password.equals(pwdConfirm)) { // Jika password dan konfirmasi password tidak sama
                            hasilValidasi = "Password dan Password Confirmation harus sama!"; // Menampilkan pesan kesalahan
                        }
                    }
                }
            }
        }

        return hasilValidasi; // Mengembalikan hasil validasi
    }

    // Method untuk memilih role
    public static String pilihRole(String role) {
        // Deklarasi variabel
        String roleInput;

        while (role.equals("")) { // Looping hingga role dipilih
            // Menampilkan pilihan role
            System.out.println();
            System.out.println("Role");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.print("Pilih role [1/2]: ");
            roleInput = scanner.nextLine(); // Membaca input role dari pengguna

            if (roleInput.equals("1")) { // Jika role adalah admin
                role = "admin"; // Set role menjadi admin
            } else if (roleInput.equals("2")) { // Jika role adalah member
                role = "member"; // Set role menjadi member
            } else { // Jika input role salah
                System.out.println("Inputan role salah! Inputkan 1 untuk admin atau 2 untuk member"); // Menampilkan pesan kesalahan
            }
        }

        return role; // Mengembalikan role yang dipilih
    }
}

class RegexValidator { // Mendefinisikan kelas RegexValidator
    // Deklarasi konstanta untuk pola regular
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PASSWORD_REGEX = ".{8,}";

    // Deklarasi variabel
    private String email;
    private String password;

    public RegexValidator(String email, String password) { // Konstruktor kelas RegexValidator
        this.email = email; // Inisialisasi email
        this.password = password != null ? password : "12345678"; // Inisialisasi password (jika null, gunakan default)
    }

    // Method untuk validasi email
    public boolean validasiEmail() {
        Pattern pattern = Pattern.compile(EMAIL_REGEX); // Membuat pola regular untuk email
        Matcher matcher = pattern.matcher(this.email); // Mencocokkan pola regular dengan email
        return matcher.matches(); // Mengembalikan hasil pencocokan
    }

    // Method untuk validasi password
    public boolean validasiPassword() {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX); // Membuat pola regular untuk password
        Matcher matcher = pattern.matcher(this.password); // Mencocokkan pola regular dengan password
        return matcher.matches(); // Mengembalikan hasil pencocokan
    }
}
