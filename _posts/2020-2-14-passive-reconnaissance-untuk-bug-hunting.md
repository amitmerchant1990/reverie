---
layout: post
title:  Passive Reconnaissance untuk Bug Hunting
categories: [Web Security]
author: Novran Faathir
---

Passive Reconnaissance adalah sebuah metode pengintaian untuk mengumpulkan informasi (Information Gathering) tanpa melakukan enumerasi secara langsung kepada target, namun kita akan memanfaatkan sebuah third-party (contohnya: seperti search engine atau mesin yang menyimpan sebuah histori target), tentunya kita akan memanfaatkan OSINT (Open Source Intelligent) untuk melakukan Passive Reconnaissance.

`Kalau bahasa simplenya seperti dukun, mencari informasi tanpa menyentuh (secara langsung) :D`

Ok! kita mulai saja, hal apa saja yang dapat kita lakukan.

## Mencari IP address dibalik Cloudflare menggunakan Historical DNS
Pada saat mencari IP address dibalik Cloudflare, biasanya saya menggunakan mesin dari:
- https://www.virustotal.com/gui/domain/target.com/relations
- https://securitytrails.com/domain/target.com/history/a
- https://viewdns.info/iphistory/?domain=target.com
- dan lain-lain.

![VirusTotal show-case](/images/passive-recon-cloudflare-virustotal.jpg "VirusTotal show-case")

## Mencari Endpoint sebuah website
Dalam Bug Hunting mencari Endpoint adalah hal terpenting untuk menemukan kerentanan pada aplikasi.

Endpoint yang saya maksud disini yaitu

- Contoh: http://target.com/api/token
```
Host: http://target.com
Endpoint: /api/token
```

**Pencarian endpoint website menggunakan mesin VirusTotal:**
- https://www.virustotal.com/gui/domain/target.com/relations (pada bagian URLs)

**Pencarian endpoint website menggunakan Google Dork:**
```
site:target.com/*
site:target.com/*/*/*
```

**Pencarian endpoint website menggunakan web.archive.org:**
- http://web.archive.org/cdx/search/cdx?url=target.com/*&output=text&fl=original&collapse=urlkey


## Mencari "parameter name" pada sebuah URL
Pencarian "parameter name" pada URL digunakan untuk mencari celah Injection seperti SQL Injection, Reflected XSS, dan lain-lain.

- Sample: `http://target.com/index.php?parameterName=value"%20onclick="alert('xss')">`

Sebagai contoh disini kita dapat menggunakan API dari **web.archive.org**
Untuk mempermudah lebih baik menggunakan shell command di bawah ini: 
```
root@linux:~# curl -s "http://web.archive.org/cdx/search/cdx?url=target.com/*&output=text&fl=original&collapse=urlkey&limit=10000" | grep -Po '\?\K.*?(?=\=)' | sort -V | uniq
...
catalogId
clkid
empty
encp
field-keywords
...
root@linux:~# 
```

Setelah itu kita fuzzing satu per satu.

Contoh:
```
root@linux:~# curl -s http://target.com/?catalogId=TESTXSS%22F | grep 'TESTXSS"F'
root@linux:~# curl -s http://target.com/?field-keywords=TESTXSS%22F | grep 'TESTXSS"F'
<a href="http://target.com/?field-keywords=TESTXSS"F">TEST</a>
```

## Mencari Port yang terbuka

Untuk menemukan port yang terbuka saya lebih sering menggunakan Shodan.

- https://www.shodan.io/host/192.168.10.20

192.168.10.20 adalah sample IP yang ingin saya ketahui port apa saja yang terbuka.

![Shodan Port Discovery](/images/passive-recon-shodan-port.png "Shodan Port Discovery")

Untuk alternatifnya kalian dapat menggunakan mesin milik https://censys.io/.

## Mencari Subdomain
Mungkin ini sudah sangat familiar untuk kalangan Bug Bounty Hunter

Mencari Subdomain menggunakan Google Dork:
```
site:*.target.com
site:*.*.target.com
```

Kalian juga dapat menggunakan mesin di bawah ini:
- https://www.virustotal.com/gui/domain/target.com/relations
- https://securitytrails.com/list/apex_domain/target.com
- https://crt.sh/?q=target.com
- http://web.archive.org/cdx/search/cdx?url=*.target.com&output=text&fl=original&collapse=urlkey

Supaya lebih cepat saat pencarian Subdomain, kalian dapat menggunakan tools di bawah ini:
- https://github.com/Screetsec/Sudomy
- https://github.com/aboul3la/Sublist3r

## Summary
Passive Reconnaissance tentunya lebih unggul untuk hal "kecepatan" namun kurang dalam hal "ketepatan" dibandingkan dengan Active Reconnaissance karena sewaktu-waktu aplikasi dapat berubah. Pada artikel ini saya hanya menggunakan beberapa mesin saja untuk dijadikan contoh, kalian dapat mengeksplor lebih lanjut dan temukan mesin-mesin kalian.

Terima kasih untuk Edo Maland, Bayu Fedra, Suhada, dan Rio untuk sharing-sharingnya sampai pagi terkait hal ini :D

Semoga artikel ini bermanfaat dan bilamana ada kesalahan jangan ragu untuk koreksi.