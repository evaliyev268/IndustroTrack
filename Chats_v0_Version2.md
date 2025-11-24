# Proje Konuşmaları (Chats_v0)

## Tarih: 2025-11-24

### Konunun Belirlenmesi
#### Kullanıcının Talebi:
Bir uygulama tasarlamak istiyoruz. Uygulama şu kriterlere uygun olmalıdır:
- "Backend Teknolojilerinde" teorik ve pratik olarak yetkinliği kanıtlamalıdır.
- "32 bit" faaliyet alanına uygun olmalıdır.
- Kullanılması gereken teknolojiler:
  - Java 17
  - Kafka
  - Spring Boot
  - Docker
  - Hibernate

---

### Farklı Konu Önerileri
#### İlk Öneri: Event-Driven Sipariş Yönetim Sistemi
Uygulama, bir e-ticaret platformunun sipariş işlemlerini yöneten bir backend sistemi olarak tasarlandı. Kafka, microservice iletişiminde olay tabanlı bir yapı oluşturmak için kullanılacak. Ancak bu konu değiştirilmek istendi.

#### İkinci Öneri: Event-Driven Öğrenci Yönetim Sistemi
Öğrencilerin kayıt, ders seçimi ve not takip işlemlerini yöneten bir sistem önerildi. Bu konu da değiştirilmek istendi.

#### Üçüncü Öneri: Otobüs Bilet Rezervasyon Sistemi
Kullanıcıların otobüs bilet rezervasyonu yapabileceği bir sistem önerildi ancak bu konu da değiştirilmek istendi.

#### Dördüncü Öneri: Yemek Sipariş ve Teslimat Yönetim Sistemi
Restoran ve kullanıcılar arasında yemek siparişlerini yöneten bir sistem önerildi. Ancak bu da sanayiye yönelik olmadığı için kabul görmedi.

#### BEĞENİLEN KONU: Sanayi için Endüstriyel Ekipman İzleme ve Tahmin Sistemi
- Proje, fabrikalardaki ekipmanların anlık durumlarını izlemek ve arızaları önceden tahmin etmek üzerine tasarlandı.
- Veri toplama, analiz ve tahmini bakım üzerine odaklanıyor.

---

### Proje Planı
#### Teknolojiler:
- Java 17
- Kafka
- Spring Boot
- Docker
- Hibernate

#### Modüller:
1. **Sensör Veri Yönetim Servisi (Sensor Data Service)**  
   Ekipmanlardan alınan sensor verilerini Kafka'ya aktarır.
   
2. **Ekipman Durum İzleme Servisi (Equipment Monitoring Service)**  
   Ekipmanların anlık durumlarını izler.

3. **Tahmin ve Analiz Servisi (Predictive Analytics Service)**  
   Arıza tahminleri yapar ve erken bildirimlerde bulunur.

4. **Bildirim Servisi (Notification Service)**  
   Kullanıcıları veya yöneticileri kritik durumlar için bilgilendirir.

5. **Raporlama ve Yönetim Paneli (Reporting & Management Dashboard)**  
   Verileri görselleştirir ve analiz sonuçlarını yöneticilere sunar.

---

### Repository İçin İsim Önerisi:
#### Kabul Edilen İsim: **IndustroTrack**
- Sanayi odaklı ve profesyonel bir izlenim bırakan bir isim seçildi.

---

### Baby Steps Adım Adım Geliştirme
#### İlk Adım: Java 17'nin Kurulumunu Yapmak
- **Neden?**  
  Java 17, backend uygulamamızın temel programlama dili olacak. Spring Boot, Hibernate ve diğer teknolojiler de Java üzerinde çalışır.
- **Kurulum:**  
  - [Java'nın resmi sitesi](https://www.oracle.com/java/technologies/javase-downloads.html)'nden Java 17 (JDK 17) indirin.
  - Kurulumdan sonra `java -version` komutuyla Java'nın doğru kurulduğunu doğrulayın.

---

#### İkinci Adım: Maven Kurulumu
- **Neden?**  
  Maven, Java projeleri için bağımlılık yönetimini sağlar. Spring Boot projeleri için gerekli olacaktır.
- **Kurulum:**  
  - [Maven'ın resmi sitesinden](https://maven.apache.org/download.cgi) indirin ve yükleyin.
  - `mvn -version` ile doğru kurulduğunu kontrol edin.

---

#### Üçüncü Adım: Docker Kurulumu
- **Neden?**  
  Docker, uygulamayı başka bir bilgisayarda çalıştırmak için taşınabilir hale getirecek ve Kafka gibi bağımlılıkları yönetmek için kullanılacak.
- **Kurulum:**  
  - [Docker resmi sitesine](https://www.docker.com/products/docker-desktop/) gidip Docker Desktop indirin.
  - Kurulumdan sonra `docker --version` ile doğrulama yapın.

---

#### Dördüncü Adım: IDE Kurulumu
- **Neden?**  
  Geliştirme sürecini kolaylaştırmak için gerekli bir araçtır. IntelliJ IDEA önerildi.
- **Kurulum:**  
  - [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/) sitesinden Community (ücretsiz) veya Ultimate sürümünü indirip kurun.

---

#### Beşinci Adım: Kafka Kurulumu
- **Neden?**  
  Mikroservisler arası iletişim altyapısı olacak.
- **Kurulum:**  
  - Kafka'nın [Apache Kafka](https://kafka.apache.org/downloads) resmi sitesinden indirilmesi.

---

### Önemli Notlar
- Adım adım kurulum tamamlandıktan sonra her bir aşama projeye eklenecek.
- Kurulum sırasında çıkan sorunlar, notlar olarak eklenecektir.