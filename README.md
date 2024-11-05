# java_isc
# Java Compiler & Implementation Alternatives

### سوال اول: معرفی سایت‌هایی به جز Oracle که Java Compiler و Java Implementation را ارائه می‌دهند:

علاوه بر شرکت Oracle که پیاده‌سازی اصلی جاوا (Java Development Kit یا همان JDK) را ارائه می‌دهد، چندین پیاده‌سازی دیگر نیز وجود دارند که از جاوا پشتیبانی می‌کنند و بعضی از آن‌ها قابلیت‌ها یا ویژگی‌های خاصی را اضافه می‌کنند و نسخه‌های خودشان از جاوا را ارائه می‌دهند. این نسخه‌ها برای محیط‌ها و نیازهای خاص بهینه‌سازی شده‌اند. 

برخی از این پیاده‌سازی‌ها شامل موارد زیر هستند:

- Microsoft Build of OpenJDK  
  شرکت ماکروسافت نسخه‌ای مخصوص خود را ارائه می‌دهد که به طور خاص برای استفاده در محیط ازورا طراحی و بهینه‌سازی شده است.

- AdoptOpenJDK (Temurin)  
  پروژه‌ای از شرکت اکلیپس که هدف آن ارائه نسخه‌ای رایگان و امن از جاوا برای استفاده تجاری است. این پروژه با نام Eclipse Adoptium و پیاده‌سازی Temurin شناخته می‌شود.

- Amazon Corretto  
  توسط شرکت امازون ارائه شده است و نسخه‌ای از جاوا را فراهم می‌کند که برای استفاده در سرویس‌های ابری این شرکت بهینه‌سازی شده است.

- IBM Semeru Runtime  
  توسط شرکت ای بی ام ارائه شده و نسخه‌ای بهینه برای محیط‌های سازمانی می‌باشد.

- Liberica JDK by BellSoft  
  نسخه‌ای است که قابلیت اجرا در محیط‌های مختلف (از جمله Docker) را دارد و برای محیط‌های ابری بهینه شده است.

- Red Hat OpenJDK  
  نسخه‌ای که به طور خاص برای سیستم‌عامل‌های Red Hat Enterprise Linux (RHEL) و دیگر سیستم‌های مبتنی بر لینوکس بهینه‌سازی شده است.

- SapMachine by SAP  
  شرکت SAP نسخه‌ای از OpenJDK تحت عنوان SapMachine ارائه می‌دهد که برای استفاده در برنامه‌های سازمانی و محیط‌های SAP بهینه‌سازی شده و به طور رسمی توسط SAP پشتیبانی می‌شود.

- Alibaba Dragonwell  
  نسخه‌ای اختصاصی از OpenJDK به نام Dragonwell که توسط Alibaba برای محیط‌های تولیدی و تجاری، مخصوصاً برای بازار چین و کسب‌وکارهای بزرگ، طراحی شده است.

- JetBrains Runtime  
  شرکت JetBrains، سازنده IDEهای معروفی مانند IntelliJ IDEA، پیاده‌سازی خاصی از JDK به نام JetBrains Runtime دارد که برای بهبود عملکرد و سازگاری در ابزارهای JetBrains طراحی شده است.

بنابراین بسته به نیاز و محیطی که در آن برنامه‌نویسی جاوا انجام می‌دهیم، می‌توانیم نسخه‌های مختلف را انتخاب کنیم. به عنوان مثال، برای کار با Azure از Microsoft OpenJDK و برای استفاده در محیط SAP از SapMachine و غیره.

---

### سوال دوم: انتخاب نوع داده مناسب برای برنامه‌نویسی سامانه‌های مالی با واحد پول ایران (ریال یا تومان)

برای برنامه‌نویسی سامانه‌های مالی در جاوا با واحد پول ایران (ریال یا تومان)، نوع داده‌ای که انتخاب می‌شود اهمیت زیادی دارد، زیرا اعداد دقیق و مدیریت مقادیر پولی بدون خطای گرد کردن بسیار حیاتی است. در این زمینه، دو انتخاب مناسب داریم:

1. استفاده از BigDecimal  
   استفاده از BigDecimal برای مقادیر مالی بسیار توصیه می‌شود، زیرا دقت بالایی را در محاسبات حفظ می‌کند. معایب آن شامل کاهش سرعت در مقایسه با انواع عددی ساده مانند `long` است، زیرا محاسبات دقیق BigDecimal پیچیده‌تر است.

2. استفاده از long  
   اگر محاسبات سریع‌تر مدنظر باشد و نیازی به دقت اعشاری وجود نداشته باشد، می‌توان مقادیر پولی را به صورت `long` ذخیره کرد. در این روش، پیچیدگی کمتری وجود دارد و سرعت محاسبات بالاتر است، اما اگر مقادیر مالی بسیار بالا باشند، استفاده از BigDecimal توصیه می‌شود.

---


 
