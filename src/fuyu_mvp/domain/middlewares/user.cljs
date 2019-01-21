(ns fuyu_mvp.domain.middlewares.user
  (:require [fuyu_mvp.domain.store :as store]))

(defn select-word [selection]
  (store/swap :selecting true)
  (store/swap :answer selection))

(defn cancel-word []
  (store/swap :selecting false)
  (store/swap :answer ""))

(defn decide-word [selection]
  (store/swap :selecting false)
  (store/swap :answer selection))
