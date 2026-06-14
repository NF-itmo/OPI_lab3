#set text(
  lang: "ru",
  size: 14pt,
  font: "New Computer Modern",
)
#set page(
  margin: 1.5cm,
  numbering: ("1")
)
#set par(justify: true)
#show raw: it => block(
  fill: luma(95%),
  inset: 8pt,
  radius: 4pt,
)[
  #set text(size: 6pt)
  #it
]
#show heading.where(level: 1): set text(oklch(30%, 0.095, 260deg))
#show heading.where(level: 2): set text(oklch(40%, 0.095, 260deg))
#show heading.where(level: 3): set text(oklch(50%, 0.095, 260deg))
#show heading.where(level: 4): set text(oklch(60%, 0.095, 260deg))
#set heading(numbering: "1.")


#align(center)[
  #text(size:12pt)[
    Федеральное государственное автономное образовательное учреждение высшего
    образования «Национальный исследовательский университет ИТМО»\
    Дисциплина «Основы программной инженерии»\
  ]
]

#align(center + horizon)[
  #box(
    width: 100%,
    height: 8cm
  )[
    #text(size: 14pt)[
      *Лабораторная работа №3*\
      Вариант №213323
    ]
  ]
]
#align(right)[  
  Выполнил:\  
  Решетников С.Е.\
      
  Проверила:\  
  Наумова Н.А.     
]

#align(center + bottom)[
  Дата сдачи: 5 июня 
  
  Cанкт-Петербург, 2026
]


#pagebreak()


= Текст задания
#image("./assets/task.png")

= Исходный код
