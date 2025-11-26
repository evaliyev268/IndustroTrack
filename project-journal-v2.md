# IndustroTrack - Proje Günlüğü (V2)

Bu dosya, IndustroTrack projesinde atılan adımların, karşılaşılan sorunların ve yapılan yapılandırmaların **güncel sürümünü** içermektedir.

## Temel Stack

- Java 17
- Kafka
- Spring Boot
- Docker
- Hibernate

## Başlangıç Adımları

### 1. Gerekli Kurulumlar

Yüklediğim araçlar:
- IntelliJ IDEA
- Docker Desktop
- Kafka 3.9.0 (ZooKeeper'siz modda)
- Java 17
- Maven

---

### 2. Spring Boot Projesi Oluşturma

- Spring Initializr ile **Maven** tabanlı yeni bir Spring Boot projesi başlatıldı.
- Eklentiler: **Spring Web, Spring Data JPA, Kafka, H2 Database** (geliştirme ve test için)
- Proje adı: `backend-tech-app` (adı ihtiyaca göre değişebilir)
- Proje IntelliJ IDEA üzerinde açıldı.
- `BackendTechAppApplication.java` ilk defa başarıyla çalıştırıldı, konsolda başlatıldığına dair mesaj alındı.

---

### 3. Proje İskeleti ve Klasörler

- `controller` klasörü açıldı.
  - İlk olarak bir `HelloController` yazıldı ve test edildi.
- `service` klasörü açıldı.
  - `KafkaProducerService` class'ı buraya yazıldı.
- `KafkaController` yazıldı ve API endpoint oluşturuldu.

---

### 4. Kafka Yapılandırması ve Topic Oluşturma

- `src/main/resources/application.properties` güncellendi:

  ```
  spring.kafka.bootstrap-servers=localhost:9092
  spring.kafka.consumer.group-id=test-group
  ```

#### Kafka Docker Kurulumu

- Proje kökünde (C: dizininde) `kafka-docker` klasörü oluşturuldu. İçine şu `docker-compose.yml` eklendi:

  ```yaml
  version: '3.8'
  services:
    kafka:
      image: confluentinc/cp-kafka:latest
      ports:
        - "9092:9092"
      environment:
        KAFKA_BROKER_ID: 1
        KAFKA_LISTENERS: PLAINTEXT://0.0.0.0:9092
        KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
        KAFKA_CONFLUENT_SUPPORT_METRICS_ENABLE: 'false'
        KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
  ```

- Terminalden Kafka başlatıldı:
  ```sh
  docker compose up -d
  ```

#### Kafka Topic Oluşturma

- Kafka container'ında terminal açıp:

  ```sh
  docker ps
  docker exec -it <kafka_container_name> kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092
  ```
  ile `test-topic` adında topic oluşturuldu.

---

### 5. Kafka Producer, Consumer ve Controller

- `KafkaProducerService` yazıldı, örnek fonksiyon:
  ```java
  public void sendMessage(String topic, String message) {
      kafkaTemplate.send(topic, message);
  }
  ```
- (Devamında yazılacak) `KafkaConsumerService` ile gelen mesajlar dinlenecek.
- REST endpoint ile mesaj gönderimi sağlanıyor:
  ```
  POST /api/kafka/publish?message=MerhabaKafka
  ```

---

### 6. Projeyi GitHub’a Yükleme

Adımlar:
1. Git repository başlatıldı:  
   `git init`
2. Dosyalar eklenip commit edildi:  
   `git add .`  
   `git commit -m "İlk commit: Spring Boot, Kafka entegrasyon başlangıcı"`
3. GitHub’da yeni repo açıldı, remote eklendi:  
   `git remote add origin <repo-url>`
4. Kod gönderildi:  
   `git branch -M main`  
   `git push -u origin main`
5. Sonraki değişikliklerde:
   ```
   git add .
   git commit -m "Mesaj"
   git push
   ```

---

## Şu Anki Durum

- Kafka Docker üzerinden ayağa kalkıyor, `test-topic` hazır.
- Spring Boot uygulaması Kafka'ya mesaj gönderip alacak şekilde entegre ediliyor.
- Proje güncel olarak GitHub'a versiyonlu olarak yükleniyor.

---

### Sonraki Adımlar (Plan)

- Hibernate kurulumu ve veri modeli tasarımına başlamak.
- Kafka Consumer tamamlamak.
- Gelişmiş örnekler ve uçtan uca testler eklemek.
- Docker ile tüm stack'i tek komutta başlatacak şekilde projeyi iyileştirmek (opsiyonel: Compose içinde app servisi).

---

**Not:**  
Sorun yaşanan bir adımda veya ileriye yönelik detaylı dokümantasyon gerektiğinde bu dosya güncellenmeye devam edecektir.