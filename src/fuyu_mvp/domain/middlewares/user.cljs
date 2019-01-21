(ns fuyu_mvp.domain.middlewares.user
  (:require [fuyu_mvp.domain.store :as store]))

(defn select-word [selection]
  (println "fired:" "select-word")
  (store/swap :selecting? true)
  (store/swap :hovering? false)
  (store/swap :answered? false)
  (store/swap :selection selection)
  (store/swap :correct? (store/get-result)))

(defn unselect-word []
  (println "fired:" "unselect-word")
  (store/swap :selecting? false)
  (store/swap :hovering? false))

(defn decide-word []
  (println "fired:" "decide-word")
  (store/swap :answered? true))

(defn enter-form []
  (println "fired:" "enter-form")
  (store/swap :hovering? true))

(defn leave-form []
  (println "fired:" "leave-form")
  (store/swap :hovering? false))
