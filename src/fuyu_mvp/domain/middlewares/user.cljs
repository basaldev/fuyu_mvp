(ns fuyu_mvp.domain.middlewares.user
  (:require [fuyu_mvp.domain.store :as store]))

(defn select-word [selection]
  (println "fired:" "select-word")
  (store/swap :selecting? true)
  (store/swap :selection selection))

(defn unselect-word []
  (println "fired:" "unselect-word")
  (store/swap :selecting? false))

(defn decide-word []
  (println "fired:" "decide-word")
  (store/swap :answered? true))

(defn enter-form []
  (println "fired:" "enter-form")
  (store/swap :hovering? true))

(defn leave-form []
  (println "fired:" "leave-form")
  (store/swap :hovering? false))
