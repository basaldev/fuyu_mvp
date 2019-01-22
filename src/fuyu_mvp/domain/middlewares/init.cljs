(ns fuyu_mvp.domain.middlewares.init
  (:require [fuyu_mvp.domain.store :as store]))

(defn randomize [question options]
  (shuffle (conj options question)))

(defn init-words []
  (store/swap :options (randomize (store/get-answer) (store/get-options))))
