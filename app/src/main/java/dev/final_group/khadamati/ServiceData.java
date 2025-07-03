package dev.final_group.khadamati;

import java.util.Arrays;
import java.util.List;

import dev.final_group.khadamati.models.Service;

public class ServiceData {
    public static final List<Service> serviceList = Arrays.asList(
            new Service(1, 1, 101, "تفصيل أبواب حديد", "أعمال حدادة لتفصيل وتركيب الأبواب والنوافذ الحديدية", 250, 4.5, R.drawable.image5),
            new Service(2, 1, 102, "صيانة شبابيك حديد", "خدمة إصلاح وصيانة الشبابيك الحديدية المتآكلة", 150, 4.2, R.drawable.image5),
            new Service(3, 2, 103, "تفصيل مطبخ خشب", "أعمال نجارة لتفصيل مطابخ حسب الطلب", 1200, 4.7, R.drawable.image2),
            new Service(4, 2, 104, "تصليح أثاث منزلي", "نجار لإصلاح وتركيب قطع الأثاث الخشبي في المنازل", 300, 4.4, R.drawable.image2),
            new Service(5, 3, 105, "تأسيس تمديدات صحية", "سباك لتركيب وتأسيس شبكات المياه والصرف الصحي", 600, 4.6, R.drawable.image1),
            new Service(6, 3, 106, "تسليك مجاري", "خدمة تسليك المجاري والمواسير المسدودة", 200, 4.1, R.drawable.image1),
            new Service(7, 4, 107, "تمديد كهرباء منزلية", "كهربائي لتركيب وتمديد شبكة كهرباء للمنازل", 800, 4.5, R.drawable.image3),
            new Service(8, 4, 108, "إصلاح أعطال كهربائية", "صيانة أعطال الكهرباء وتغيير المفاتيح والأسلاك", 250, 4.3, R.drawable.image3),
            new Service(9, 5, 109, "تنظيف منازل", "خدمة تنظيف منازل كاملة شاملاً الأرضيات والنوافذ", 100, 4.6, R.drawable.image4),
            new Service(10, 5, 110, "ترتيب وتنظيم المنزل", "خدمة ترتيب غرف المنزل وتنظيم الأغراض", 120, 4.2, R.drawable.image4),
            new Service(11, 6, 111, "دهان داخلي", "دهان الجدران الداخلية بألوان حسب الطلب", 500, 4.5, R.drawable.image6),
            new Service(12, 6, 112, "دهان خارجي", "دهان واجهات المنازل والفلل بدهانات مقاومة", 700, 4.3, R.drawable.image6),
            new Service(13, 1, 113, "تركيب بوابات حديد", "تصميم وتركيب بوابات حديد للمنازل والفلل", 1000, 4.4, R.drawable.image5),
            new Service(14, 2, 114, "تفصيل خزائن خشب", "نجارة لتفصيل خزائن وحلول تخزين عملية", 900, 4.6, R.drawable.image2),
            new Service(15, 3, 115, "كشف تسربات المياه", "خدمة كشف التسربات باستخدام أحدث الأجهزة", 350, 4.5, R.drawable.image1)
    );
}
