/*
 Navicat Premium Data Transfer

 Source Server         : kemenag_lajnah
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 22/11/2019 08:41:43
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for namasurat
-- ----------------------------
DROP TABLE IF EXISTS "namasurat";
CREATE TABLE "namasurat" (
  "id" integer,
  "namalatin" text,
  "jumlahayat" integer,
  "namaarab" text,
  "kategory" text,
  "terjemah" text,
  "posisi" integer
);

-- ----------------------------
-- Records of namasurat
-- ----------------------------
INSERT INTO "namasurat" VALUES (1, 'Al-Fatihah', 7, ' الفاتحة', 'Makkiyah', 'Pembukaan', 0);
INSERT INTO "namasurat" VALUES (2, 'Al-Baqarah', 286, ' البقرة', 'Madaniyah', 'Sapi', 7);
INSERT INTO "namasurat" VALUES (3, 'Ali ''Imran', 200, ' اٰل عمران', 'Madaniyah', 'Keluarga Imran', 293);
INSERT INTO "namasurat" VALUES (4, 'An-Nisa''', 176, ' النساۤء', 'Madaniyah', 'Wanita', 493);
INSERT INTO "namasurat" VALUES (5, 'Al-Ma''idah', 120, ' الماۤئدة', 'Madaniyah', 'Hidangan', 669);
INSERT INTO "namasurat" VALUES (6, 'Al-An''am', 165, ' الانعام', 'Makkiyah', 'Binatang Ternak', 789);
INSERT INTO "namasurat" VALUES (7, 'Al-A''raf', 206, ' الاعراف', 'Makkiyah', 'Tempat Tertinggi', 954);
INSERT INTO "namasurat" VALUES (8, 'Al-Anfal', 75, ' الانفال', 'Madaniyah', 'Rampasan Perang', 1160);
INSERT INTO "namasurat" VALUES (9, 'At-Taubah', 129, ' التوبة', 'Madaniyah', 'Pengampunan', 1235);
INSERT INTO "namasurat" VALUES (10, 'Yunus', 109, ' يونس', 'Makkiyah', 'Yunus', 1364);
INSERT INTO "namasurat" VALUES (11, 'Hud', 123, ' هود', 'Makkiyah', 'Hud', 1473);
INSERT INTO "namasurat" VALUES (12, 'Yusuf', 111, ' يوسف', 'Makkiyah', 'Yusuf', 1596);
INSERT INTO "namasurat" VALUES (13, 'Ar-Ra''d', 43, ' الرّعد', 'Makkiyah', 'Guruh', 1707);
INSERT INTO "namasurat" VALUES (14, 'Ibrahim', 52, ' ابرٰهيم', 'Makkiyah', 'Ibrahim', 1750);
INSERT INTO "namasurat" VALUES (15, 'Al-Hijr', 99, ' الحجر', 'Makkiyah', 'Hijr', 1802);
INSERT INTO "namasurat" VALUES (16, 'An-Nahl', 128, ' النحل', 'Makkiyah', 'Lebah', 1901);
INSERT INTO "namasurat" VALUES (17, 'Al-Isra''', 111, ' الاسراۤء', 'Makkiyah', 'Memperjalankan Malam Hari', 2029);
INSERT INTO "namasurat" VALUES (18, 'Al-Kahf', 110, ' الكهف', 'Makkiyah', 'Goa', 2140);
INSERT INTO "namasurat" VALUES (19, 'Maryam', 98, ' مريم', 'Makkiyah', 'Maryam', 2250);
INSERT INTO "namasurat" VALUES (20, 'Taha', 135, ' طٰهٰ', 'Makkiyah', 'Taha', 2348);
INSERT INTO "namasurat" VALUES (21, 'Al-Anbiya''', 112, ' الانبياۤء', 'Makkiyah', 'Para Nabi', 2483);
INSERT INTO "namasurat" VALUES (22, 'Al-Hajj', 78, ' الحج', 'Madaniyah', 'Haji', 2595);
INSERT INTO "namasurat" VALUES (23, 'Al-Mu''minun', 118, ' المؤمنون', 'Makkiyah', 'Orang-Orang Mukmin', 2673);
INSERT INTO "namasurat" VALUES (24, 'An-Nur', 64, ' النّور', 'Madaniyah', 'Cahaya', 2791);
INSERT INTO "namasurat" VALUES (25, 'Al-Furqan', 77, ' الفرقان', 'Makkiyah', 'Pembeda', 2855);
INSERT INTO "namasurat" VALUES (26, 'Asy-Syu''ara''', 227, ' الشعراۤء', 'Makkiyah', 'Para Penyair', 2932);
INSERT INTO "namasurat" VALUES (27, 'An-Naml', 93, ' النمل', 'Makkiyah', 'Semut-semut', 3159);
INSERT INTO "namasurat" VALUES (28, 'Al-Qasas', 88, ' القصص', 'Makkiyah', 'Kisah-Kisah', 3252);
INSERT INTO "namasurat" VALUES (29, 'Al-''Ankabut', 69, ' العنكبوت', 'Makkiyah', 'Laba-Laba', 3340);
INSERT INTO "namasurat" VALUES (30, 'Ar-Rum', 60, ' الرّوم', 'Makkiyah', 'Romawi', 3409);
INSERT INTO "namasurat" VALUES (31, 'Luqman', 34, ' لقمٰن', 'Makkiyah', 'Luqman', 3469);
INSERT INTO "namasurat" VALUES (32, 'As-Sajdah', 30, ' السّجدة', 'Makkiyah', 'Sajdah', 3503);
INSERT INTO "namasurat" VALUES (33, 'Al-Ahzab', 73, ' الاحزاب', 'Madaniyah', 'Golongan Yang Bersekutu', 3533);
INSERT INTO "namasurat" VALUES (34, 'Saba''', 54, ' سبأ', 'Makkiyah', 'Saba''', 3606);
INSERT INTO "namasurat" VALUES (35, 'Fatir', 45, ' فاطر', 'Makkiyah', 'Maha Pencipta', 3660);
INSERT INTO "namasurat" VALUES (36, 'Yasin', 83, ' يٰسۤ', 'Makkiyah', 'Yasin', 3705);
INSERT INTO "namasurat" VALUES (37, 'As-Saffat', 182, ' الصّٰۤفّٰت', 'Makkiyah', 'Barisan-Barisan', 3788);
INSERT INTO "namasurat" VALUES (38, 'Sad', 88, ' ص', 'Makkiyah', 'Sad', 3970);
INSERT INTO "namasurat" VALUES (39, 'Az-Zumar', 75, ' الزمر', 'Makkiyah', 'Rombongan', 4058);
INSERT INTO "namasurat" VALUES (40, 'Gafir', 85, ' غافر', 'Makkiyah', 'Maha Pengampun', 4133);
INSERT INTO "namasurat" VALUES (41, 'Fussilat', 54, ' فصّلت', 'Makkiyah', 'Yang Dijelaskan', 4218);
INSERT INTO "namasurat" VALUES (42, 'Asy-Syura', 53, ' الشورى', 'Makkiyah', 'Musyawarah', 4272);
INSERT INTO "namasurat" VALUES (43, 'Az-Zukhruf', 89, ' الزخرف', 'Makkiyah', 'Perhiasan', 4325);
INSERT INTO "namasurat" VALUES (44, 'Ad-Dukhan', 59, ' الدخان', 'Makkiyah', 'Kabut', 4414);
INSERT INTO "namasurat" VALUES (45, 'Al-Jasiyah', 37, ' الجاثية', 'Makkiyah', 'Berlutut', 4473);
INSERT INTO "namasurat" VALUES (46, 'Al-Ahqaf', 35, ' الاحقاف', 'Makkiyah', 'Bukit Pasir', 4510);
INSERT INTO "namasurat" VALUES (47, 'Muhammad', 38, ' محمّد', 'Madaniyah', 'Muhammad', 4545);
INSERT INTO "namasurat" VALUES (48, 'Al-Fath', 29, ' الفتح', 'Madaniyah', 'Kemenangan', 4583);
INSERT INTO "namasurat" VALUES (49, 'Al-Hujurat', 18, ' الحجرٰت', 'Madaniyah', 'Kamar-Kamar', 4612);
INSERT INTO "namasurat" VALUES (50, 'Qaf', 45, ' ق', 'Makkiyah', 'Qaf', 4630);
INSERT INTO "namasurat" VALUES (51, 'Az-Zariyat', 60, ' الذّٰريٰت', 'Makkiyah', 'Angin yang Menerbangkan', 4675);
INSERT INTO "namasurat" VALUES (52, 'At-Tur', 49, ' الطور', 'Makkiyah', 'Bukit Tursina', 4735);
INSERT INTO "namasurat" VALUES (53, 'An-Najm', 62, ' النجم', 'Makkiyah', 'Bintang', 4784);
INSERT INTO "namasurat" VALUES (54, 'Al-Qamar', 55, ' القمر', 'Makkiyah', 'Bulan', 4846);
INSERT INTO "namasurat" VALUES (55, 'Ar-Rahman', 78, ' الرحمن', 'Makkiyah', 'Maha Pengasih', 4901);
INSERT INTO "namasurat" VALUES (56, 'Al-Waqi''ah', 96, ' الواقعة', 'Makkiyah', 'Hari Kiamat', 4979);
INSERT INTO "namasurat" VALUES (57, 'Al-Hadid', 29, ' الحديد', 'Madaniyah', 'Besi', 5075);
INSERT INTO "namasurat" VALUES (58, 'Al-Mujadalah', 22, ' المجادلة', 'Madaniyah', 'Gugatan', 5104);
INSERT INTO "namasurat" VALUES (59, 'Al-Hasyr', 24, ' الحشر', 'Madaniyah', 'Pengusiran', 5126);
INSERT INTO "namasurat" VALUES (60, 'Al-Mumtahanah', 13, ' الممتحنة', 'Madaniyah', 'Wanita Yang Diuji', 5150);
INSERT INTO "namasurat" VALUES (61, 'As-Saff', 14, ' الصّفّ', 'Madaniyah', 'Barisan', 5163);
INSERT INTO "namasurat" VALUES (62, 'Al-Jumu''ah', 11, ' الجمعة', 'Madaniyah', 'Jumat', 5177);
INSERT INTO "namasurat" VALUES (63, 'Al-Munafiqun', 11, ' المنٰفقون', 'Madaniyah', 'Orang-Orang Munafik', 5188);
INSERT INTO "namasurat" VALUES (64, 'At-Tagabun', 18, ' التغابن', 'Madaniyah', 'Pengungkapan Kesalahan', 5199);
INSERT INTO "namasurat" VALUES (65, 'At-Talaq', 12, ' الطلاق', 'Madaniyah', 'Talak', 5217);
INSERT INTO "namasurat" VALUES (66, 'At-Tahrim', 12, ' التحريم', 'Madaniyah', 'Pengharaman', 5229);
INSERT INTO "namasurat" VALUES (67, 'Al-Mulk', 30, ' الملك', 'Makkiyah', 'Kerajaan', 5241);
INSERT INTO "namasurat" VALUES (68, 'Al-Qalam', 52, ' القلم', 'Makkiyah', 'Pena', 5271);
INSERT INTO "namasurat" VALUES (69, 'Al-Haqqah', 52, ' الحاۤقّة', 'Makkiyah', 'Hari Kiamat', 5323);
INSERT INTO "namasurat" VALUES (70, 'Al-Ma''arij', 44, ' المعارج', 'Makkiyah', 'Tempat Naik', 5375);
INSERT INTO "namasurat" VALUES (71, 'Nuh', 28, ' نوح', 'Makkiyah', 'Nuh', 5419);
INSERT INTO "namasurat" VALUES (72, 'Al-Jinn', 28, ' الجن', 'Makkiyah', 'Jin', 5447);
INSERT INTO "namasurat" VALUES (73, 'Al-Muzzammil', 20, ' المزّمّل', 'Makkiyah', 'Orang Yang Berselimut', 5475);
INSERT INTO "namasurat" VALUES (74, 'Al-Muddassir', 56, ' المدّثّر', 'Makkiyah', 'Orang Yang Berkemul', 5495);
INSERT INTO "namasurat" VALUES (75, 'Al-Qiyamah', 40, ' القيٰمة', 'Makkiyah', 'Hari Kiamat', 5551);
INSERT INTO "namasurat" VALUES (76, 'Al-Insan', 31, ' الانسان', 'Madaniyah', 'Manusia', 5591);
INSERT INTO "namasurat" VALUES (77, 'Al-Mursalat', 50, ' المرسلٰت', 'Makkiyah', 'Malaikat Yang Diutus', 5622);
INSERT INTO "namasurat" VALUES (78, 'An-Naba''', 40, ' النبأ', 'Makkiyah', 'Berita Besar', 5672);
INSERT INTO "namasurat" VALUES (79, 'An-Nazi''at', 46, ' النّٰزعٰت', 'Makkiyah', 'Malaikat Yang Mencabut', 5712);
INSERT INTO "namasurat" VALUES (80, '''Abasa', 42, ' عبس', 'Makkiyah', 'Bermuka Masam', 5758);
INSERT INTO "namasurat" VALUES (81, 'At-Takwir', 29, ' التكوير', 'Makkiyah', 'Penggulungan', 5800);
INSERT INTO "namasurat" VALUES (82, 'Al-Infitar', 19, ' الانفطار', 'Makkiyah', 'Terbelah', 5829);
INSERT INTO "namasurat" VALUES (83, 'Al-Mutaffifin', 36, ' المطفّفين', 'Makkiyah', 'Orang-Orang Curang', 5848);
INSERT INTO "namasurat" VALUES (84, 'Al-Insyiqaq', 25, ' الانشقاق', 'Makkiyah', 'Terbelah', 5884);
INSERT INTO "namasurat" VALUES (85, 'Al-Buruj', 22, ' البروج', 'Makkiyah', 'Gugusan Bintang', 5909);
INSERT INTO "namasurat" VALUES (86, 'At-Tariq', 17, ' الطارق', 'Makkiyah', 'Yang Datang Di Malam Hari', 5931);
INSERT INTO "namasurat" VALUES (87, 'Al-A''la', 19, ' الاعلى', 'Makkiyah', 'Maha Tinggi', 5948);
INSERT INTO "namasurat" VALUES (88, 'Al-Gasyiyah', 26, ' الغاشية', 'Makkiyah', 'Hari Kiamat', 5967);
INSERT INTO "namasurat" VALUES (89, 'Al-Fajr', 30, ' الفجر', 'Makkiyah', 'Fajar', 5993);
INSERT INTO "namasurat" VALUES (90, 'Al-Balad', 20, ' البلد', 'Makkiyah', 'Negeri', 6023);
INSERT INTO "namasurat" VALUES (91, 'Asy-Syams', 15, ' الشمس', 'Makkiyah', 'Matahari', 6043);
INSERT INTO "namasurat" VALUES (92, 'Al-Lail', 21, ' الّيل', 'Makkiyah', 'Malam', 6058);
INSERT INTO "namasurat" VALUES (93, 'Ad-Duha', 11, ' الضحى', 'Makkiyah', 'Duha', 6079);
INSERT INTO "namasurat" VALUES (94, 'Asy-Syarh', 8, ' الشرح', 'Makkiyah', 'Lapang', 6090);
INSERT INTO "namasurat" VALUES (95, 'At-Tin', 8, ' التين', 'Makkiyah', 'Buah Tin', 6098);
INSERT INTO "namasurat" VALUES (96, 'Al-''Alaq', 19, ' العلق', 'Makkiyah', 'Segumpal Darah', 6106);
INSERT INTO "namasurat" VALUES (97, 'Al-Qadr', 5, ' القدر', 'Makkiyah', 'Kemuliaan', 6125);
INSERT INTO "namasurat" VALUES (98, 'Al-Bayyinah', 8, ' البيّنة', 'Madaniyah', 'Bukti Nyata', 6130);
INSERT INTO "namasurat" VALUES (99, 'Az-Zalzalah', 8, ' الزلزلة', 'Madaniyah', 'Guncangan', 6138);
INSERT INTO "namasurat" VALUES (100, 'Al-''Adiyat', 11, ' العٰديٰت', 'Makkiyah', 'Kuda Yang Berlari Kencang', 6146);
INSERT INTO "namasurat" VALUES (101, 'Al-Qari''ah', 11, ' القارعة', 'Makkiyah', 'Hari Kiamat', 6157);
INSERT INTO "namasurat" VALUES (102, 'At-Takasur', 8, ' التكاثر', 'Makkiyah', 'Bermegah-Megahan', 6168);
INSERT INTO "namasurat" VALUES (103, 'Al-''Asr', 3, ' العصر', 'Makkiyah', 'Asar', 6176);
INSERT INTO "namasurat" VALUES (104, 'Al-Humazah', 9, ' الهمزة', 'Makkiyah', 'Pengumpat', 6179);
INSERT INTO "namasurat" VALUES (105, 'Al-Fil', 5, ' الفيل', 'Makkiyah', 'Gajah', 6188);
INSERT INTO "namasurat" VALUES (106, 'Quraisy', 4, ' قريش', 'Makkiyah', 'Quraisy', 6193);
INSERT INTO "namasurat" VALUES (107, 'Al-Ma''un', 7, ' الماعون', 'Makkiyah', 'Barang Yang Berguna', 6197);
INSERT INTO "namasurat" VALUES (108, 'Al-Kausar', 3, ' الكوثر', 'Makkiyah', 'Pemberian Yang Banyak', 6204);
INSERT INTO "namasurat" VALUES (109, 'Al-Kafirun', 6, ' الكٰفرون', 'Makkiyah', 'Orang-Orang kafir', 6207);
INSERT INTO "namasurat" VALUES (110, 'An-Nasr', 3, ' النصر', 'Madaniyah', 'Pertolongan', 6213);
INSERT INTO "namasurat" VALUES (111, 'Al-Lahab', 5, ' اللهب', 'Makkiyah', 'Api Yang Bergejolak', 6216);
INSERT INTO "namasurat" VALUES (112, 'Al-Ikhlas', 4, ' الاخلاص', 'Makkiyah', 'Ikhlas', 6221);
INSERT INTO "namasurat" VALUES (113, 'Al-Falaq', 5, ' الفلق', 'Madaniyah', 'Subuh', 6225);
INSERT INTO "namasurat" VALUES (114, 'An-Nas', 6, ' الناس', 'Madaniyah', 'Manusia', 6230);

PRAGMA foreign_keys = true;
