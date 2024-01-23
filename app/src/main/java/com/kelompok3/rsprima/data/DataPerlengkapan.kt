package com.kelompok3.rsprima.data

import com.kelompok3.rsprima.model.ListObjPerlengkapan

class DataPerlengkapan {
    companion object{
        fun buatSetData(): ArrayList<ListObjPerlengkapan> {
            val list = ArrayList<ListObjPerlengkapan>()
            list.add(
                ListObjPerlengkapan(
                    "TERMOMETER",
                    "Termometer adalah alat yang digunakan untuk mengukur suhu (temperatur), ataupun perubahan suhu. Istilah termometer berasal dari bahasa Latin thermo yang berarti panas dan meter yang berarti untuk mengukur. Prinsip kerja termometer ada bermacam-macam, yang paling umum digunakan adalah termometer air raksa.",
                    "1000",
                    "Tersedia",
                    "https://cdn.pixabay.com/photo/2013/07/12/18/39/clinical-thermometer-153666__340.png"
                )
            )
            list.add(
                ListObjPerlengkapan(
                    "TIMBANGAN MEDIS",
                    "Jangan kira bahwa timbangan berat badan hanya untuk orang yang sedang menjalani diet atau menjaga berat badan saja. Alat kesehatan ini wajib ada di rumah meskipun kamu tidak sedang diet.",
                    "10",
                    "Tersedia",
                    "https://cdn.pixabay.com/photo/2016/01/12/15/15/horizontal-1135788__340.png"
                )
            )
            list.add(
                ListObjPerlengkapan(
                    "GLUCOSE METER",
                    "Alat kesehatan ini memiliki slot di mana strip sekali pakai ditempatkan dan layar yang menunjukkan glikemia (pengukuran glukosa). Dilengkapi dengan semacam ‘pulpen’ berisi jarum yang akan ditusukkan ke jari, lalu darah yang keluar akan ditempatkan pada strip tes.",
                    "50",
                    "Tersedia",
                    "https://cdn.pixabay.com/photo/2016/10/02/19/50/diabetes-1710296__340.png"
                )
            )
            list.add(
                ListObjPerlengkapan(
                    "GAS OKSIGEN",
                    "Tabung oksigen adalah alat yang penting untuk disediakan di rumah bagi orang yang mengidap penyakit tertentu, seperti asma, penyakit paru obstruktif kronis (PPOK), stroke, dan gagal jantung.",
                    "100",
                    "Tersedia",
                    "https://cdn.pixabay.com/photo/2021/05/07/17/09/oxygen-tank-6236702__340.png"
                )
            )
            return list
        }
    }
}